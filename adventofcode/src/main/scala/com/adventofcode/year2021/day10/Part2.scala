package com.adventofcode.year2021.day10

/** Day 10: Syntax Scoring (Part 2)
  * https://adventofcode.com/2021/day/10#part2
  */
object Part2 extends App {

  implicit final class LineOps(private val line: String) extends AnyVal {

    def complete: Either[Int, List[Char]] = {
      val size = line.length

      @annotation.tailrec
      def go(index: Int, brackets: List[Char]): Either[Int, List[Char]] =
        if (index == size) Right(brackets.map {
          case '(' => ')'
          case '[' => ']'
          case '{' => '}'
          case '<' => '>'
        })
        else
          line(index) match {
            case open @ ('(' | '[' | '{' | '<') => go(index + 1, open :: brackets)
            case close                          =>
              brackets match {
                case '(' :: brackets if close == ')' => go(index + 1, brackets)
                case '[' :: brackets if close == ']' => go(index + 1, brackets)
                case '{' :: brackets if close == '}' => go(index + 1, brackets)
                case '<' :: brackets if close == '>' => go(index + 1, brackets)
                case _                               => Left(index)
              }
          }

      go(0, List.empty[Char])
    }

  }

  val source = scala.io.Source.fromResource("year2021/day10/input.txt").getLines()

  val scores = source.collect { line =>
    line.complete match {
      case Right(brackets) =>
        brackets.foldLeft(0L) {
          case (score, ')') => score * 5 + 1
          case (score, ']') => score * 5 + 2
          case (score, '}') => score * 5 + 3
          case (score, '>') => score * 5 + 4
          case (score, _)   => score * 5
        }
    }
  }.toList

  val middle = scores.sorted.apply(scores.length / 2)

  println(s"What is the middle score? $middle")
}
