package com.adventofcode.year2023.day03

/** Day 3: Gear Ratios
  *   - https://adventofcode.com/2023/day/3
  */
object Part1 extends App {

  final case class EngineSchematic(lines: List[String]) {
    private val matrix: Array[Array[Char]] = lines.map(_.toCharArray).toArray

    def partNumbers: List[Int] =
      lines.zipWithIndex.foldLeft(List.empty[Int]) { case (numbers, (line, row)) =>
        s"$line.".zipWithIndex
          .foldLeft((numbers, "")) {
            case ((numbers, digits), (d, _)) if d.isDigit => (numbers, s"$digits$d")

            case ((numbers, digits), (_, column)) if digits.nonEmpty =>
              if (isAdjacentToSymbol(row, column - digits.length - 1, column))
                (digits.toInt :: numbers, "")
              else
                (numbers, "")

            case (state, _) => state
          }
          ._1
      }

    private def isAdjacentToSymbol(row: Int, from: Int, to: Int): Boolean =
      (row - 1).to(row + 1).foldLeft(false) {
        case (true, _)                       => true
        case (_, r) if matrix.isDefinedAt(r) =>
          from.to(to).foldLeft(false) {
            case (true, _)                          => true
            case (_, c) if matrix(r).isDefinedAt(c) => !matrix(r)(c).isDigit && matrix(r)(c) != '.'
            case _                                  => false
          }
        case _                               => false
      }
  }

  val lines           = scala.io.Source.fromResource("year2023/day03/input.txt").getLines().toList
  val engineSchematic = EngineSchematic(lines)

  val answer = engineSchematic.partNumbers.foldLeft(0L)(_ + _)
  println(answer)
}
