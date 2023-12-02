package com.adventofcode.year2023.day02

/** Day 2: Cube Conundrum
  *   - https://adventofcode.com/2023/day/2#part2
  */
object Part2 extends App {

  final case class Game(id: Int, red: Int = 0, blue: Int = 0, green: Int = 0) { self =>

    def union: Game => Game = { case Game(_, red, blue, green) =>
      Game(self.id, red max self.red, blue max self.blue, green max self.green)
    }

    def power: Long = 1L * red * blue * green
  }

  object Game {

    def apply(input: String): Game = input match {
      case s"Game $index: $games" =>
        val id = index.toIntOption.getOrElse(0)

        games
          .split(';')
          .foldLeft(Game(id)) { (game, input) =>
            val games = input.split(',').toList.map(_.trim).map {
              case s"$count red"   => Game(id, red = count.toIntOption.getOrElse(0))
              case s"$count blue"  => Game(id, blue = count.toIntOption.getOrElse(0))
              case s"$count green" => Game(id, green = count.toIntOption.getOrElse(0))
              case _               => Game(id)
            }

            (game :: games).reduce(_ union _)
          }
      case _                      => Game(0)
    }
  }

  val sources = scala.io.Source.fromResource("year2023/day02/input.txt").getLines().toList
  val answer  = sources.map(Game.apply(_)).foldLeft(0L)(_ + _.power)

  println(answer)
}
