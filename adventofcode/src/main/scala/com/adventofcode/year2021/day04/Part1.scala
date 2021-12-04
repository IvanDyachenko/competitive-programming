package com.adventofcode.year2021.day04

/** Day 4. Giant Squid. Part 1
  * https://adventofcode.com/2021/day/4
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day04/input.txt").getLines().toList

  final case class Board(grid: IndexedSeq[Int]) {
    private val lines: List[IndexedSeq[Int]] = {
      val rows    = (0 until 5).toList.map { row => grid.slice(row * 5, row * 5 + 5) }
      val columns = (0 until 5).toList.map { column => (0 until 5).map(row => grid(row * 5 + column)) }

      rows ::: columns
    }

    def score(numbers: Map[Int, Int]): Option[(Int, Long)] =
      lines.foldLeft[Option[(Int, Long)]](None) {
        case (bestOpt, line) if line.forall(numbers.contains) =>
          val (number, position) = line.foldLeft((0, 0)) {
            case ((_, position), number) if numbers(number) >= position => (number, numbers(number))
            case (result, _)                                            => result
          }

          val total = grid.foldLeft(0L) {
            case (total, number) if numbers.contains(number) && numbers(number) <= position => total
            case (total, number)                                                            => total + number
          }

          val score = total * number

          bestOpt match {
            case None                                                        => Some((position, score))
            case Some((bestPosition, bestScore)) if position < bestPosition  => Some((position, score))
            case Some((bestPosition, bestScore)) if position == bestPosition => Some((position, score max bestScore))
            case _                                                           => bestOpt
          }
        case (bestOpt, _)                                     => bestOpt
      }
  }

  object Board {
    def fromString(input: Seq[String]): Board = {
      val grid = input.flatMap { line =>
        line.split(" ").collect { case str if str.nonEmpty => str.toInt }
      }.toArray
      Board(grid)
    }
  }

  final case class Bingo(numbers: Map[Int, Int], boards: List[Board]) {
    def score: Option[(Int, Long)] = boards
      .foldLeft[Option[(Int, Long)]](None) {
        case (winner @ Some((winnerMoves, winnerScore)), board) =>
          board
            .score(numbers)
            .map {
              case (boardMoves, boardScore) if boardMoves < winnerMoves  => (boardMoves, boardScore)
              case (boardMoves, boardScore) if boardMoves == winnerMoves => (winnerMoves, winnerScore max boardScore)
              case _                                                     => (winnerMoves, winnerScore)
            }
            .orElse(winner)
        case (_, board)                                         => board.score(numbers)
      }
  }

  object Bingo {

    def fromString(input: Seq[String]): Bingo = {
      val numbers = input.head.split(",").map(_.toInt).zipWithIndex.toMap
      val boards  = input.tail.sliding(6, 6).foldLeft(List.empty[Board]) { (boards, lines) =>
        Board.fromString(lines) :: boards
      }
      Bingo(numbers, boards)
    }
  }

  val bingo = Bingo.fromString(source)

  bingo.score match {
     case Some((moves, score)) =>
       println(s"moves=$moves score=$score")
     case _                    =>
   }
}
