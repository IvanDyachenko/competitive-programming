package com.adventofcode.year2021.day10

/** Day 10: Syntax Scoring (Part 1)
  * https://adventofcode.com/2021/day/10
  */
object Part1 extends App {

  implicit final class LineOps(private val line: String) extends AnyVal {

    def validate: Option[Int] = {
      val size = line.length

      @annotation.tailrec
      def go(index: Int, brackets: List[Char]): Option[Int] =
        if (index == size) None
        else
          line(index) match {
            case open @ ('(' | '[' | '{' | '<') => go(index + 1, open :: brackets)
            case close                          =>
              brackets match {
                case '(' :: brackets if close == ')' => go(index + 1, brackets)
                case '[' :: brackets if close == ']' => go(index + 1, brackets)
                case '{' :: brackets if close == '}' => go(index + 1, brackets)
                case '<' :: brackets if close == '>' => go(index + 1, brackets)
                case _                               => Some(index)
              }
          }

      go(0, List.empty[Char])
    }

  }

  val source = scala.io.Source.fromResource("year2021/day10/input.txt").getLines()

  val score = source.foldLeft(0) { (score, line) =>
    line.validate.map(line).foldLeft(score) {
      case (score, ')') => score + 3
      case (score, ']') => score + 57
      case (score, '}') => score + 1197
      case (score, '>') => score + 25137
      case (score, _)   => score
    }
  }

  println(s"What is the total syntax error score for those errors? $score")
}
