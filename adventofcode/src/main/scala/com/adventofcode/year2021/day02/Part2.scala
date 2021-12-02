package com.adventofcode.year2021.day02

/** Day 2. Dive! Part 2
  * https://adventofcode.com/2021/day/2#part2
  */
object Part2 extends App {
  sealed trait Command {
    def value: Int
  }
  case class Up(value: Int)      extends Command
  case class Down(value: Int)    extends Command
  case class Forward(value: Int) extends Command

  object Command {
    def fromString(str: String): Command = str match {
      case s"up $value"      => Up(value.toInt)
      case s"down $value"    => Down(value.toInt)
      case s"forward $value" => Forward(value.toInt)
    }
  }

  case class Position(horizontal: Int, depth: Int, aim: Int) {
    def move(command: Command): Position = command match {
      case Up(value)      => Position(horizontal, depth, aim - value)
      case Down(value)    => Position(horizontal, depth, aim + value)
      case Forward(value) => Position(horizontal + value, depth + aim * value, aim)
    }
  }

  val source = scala.io.Source.fromResource("year2021/day02/input.txt").getLines()

  val commands = source.map(Command.fromString)
  val position = commands.foldLeft(Position(0, 0, 0))(_ move _)
  val multiply = 1L * position.depth * position.horizontal

  println(position)
  println(multiply)
}
