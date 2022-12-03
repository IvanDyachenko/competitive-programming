package com.adventofcode.year2022.day02

/** Day 2: Rock Paper Scissors
  *   - https://adventofcode.com/2022/day/2#part2
  */
object Part2 extends App {

  sealed trait HandShape {
    def loses: HandShape
    def defeats: HandShape
  }

  object HandShape {
    final case object Rock extends HandShape {
      def loses: HandShape   = Paper
      def defeats: HandShape = Scissors
    }

    final case object Paper extends HandShape {
      def loses: HandShape   = Scissors
      def defeats: HandShape = Rock
    }

    final case object Scissors extends HandShape {
      def loses: HandShape   = Rock
      def defeats: HandShape = Paper
    }

    def decrypt: String => HandShape = {
      case "A" => Rock
      case "B" => Paper
      case "C" => Scissors
    }
  }

  final case class Round(shape: HandShape, end: Round.End) {
    import Round._

    def score: Int = end match {
      case End.Win  => end.score + shape.loses.score
      case End.Draw => end.score + shape.score
      case End.Lose => end.score + shape.defeats.score
    }
  }

  object Round {

    sealed trait End {

      def score: Int = this match {
        case End.Win  => 6
        case End.Draw => 3
        case End.Lose => 0
      }
    }

    object End {
      final case object Win  extends End
      final case object Draw extends End
      final case object Lose extends End

      def decrypt: String => End = {
        case "Z" => Win
        case "Y" => Draw
        case "X" => Lose
      }
    }

    def decrypt: String => Round = { case s"$shape $end" =>
      Round(HandShape.decrypt(shape), End.decrypt(end))
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
