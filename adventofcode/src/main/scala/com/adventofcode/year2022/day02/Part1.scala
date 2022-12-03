package com.adventofcode.year2022.day02

/** Day 2: Rock Paper Scissors
  *   - https://adventofcode.com/2022/day/2#part1
  */
object Part1 extends App {

  sealed trait HandShape

  object HandShape {
    final case object Rock     extends HandShape
    final case object Paper    extends HandShape
    final case object Scissors extends HandShape

    def decrypt: String => HandShape = {
      case "A" | "X" => Rock
      case "B" | "Y" => Paper
      case "C" | "Z" => Scissors
    }

    implicit val ordering: Ordering[HandShape] = Ordering.fromLessThan {
      case (Rock, Rock)     => false
      case (Rock, Paper)    => true
      case (Rock, Scissors) => false

      case (Paper, Rock)     => false
      case (Paper, Paper)    => false
      case (Paper, Scissors) => true

      case (Scissors, Rock)     => true
      case (Scissors, Paper)    => false
      case (Scissors, Scissors) => false
    }
  }

  final case class Round(you: HandShape, opponent: HandShape) {
    import Round._
    import HandShape.ordering._

    def score: Int = you.score + end

    private def end: Int = Ordering[HandShape].compare(you, opponent) match {
      case sign if sign > 0 => 6
      case sign if sign < 0 => 0
      case _                => 3
    }
  }

  object Round {

    def decrypt: String => Round = { case s"$opponent $you" =>
      Round(you = HandShape.decrypt(you), opponent = HandShape.decrypt(opponent))
    }

    implicit final class HandShapeOps(private val shape: HandShape) extends AnyVal {

      def score: Int = shape match {
        case HandShape.Rock     => 1
        case HandShape.Paper    => 2
        case HandShape.Scissors => 3
      }
    }
  }

  val sources = scala.io.Source.fromResource("year2022/day02/input.txt").getLines().toList
  val rounds  = sources.map(Round.decrypt)
  val answer  = rounds.foldLeft(0)(_ + _.score)

  println(answer)
}
