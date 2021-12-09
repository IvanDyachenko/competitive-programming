package com.adventofcode.year2021.day08

/** Day 8: Seven Segment Search. Part 1
  * https://adventofcode.com/2021/day/8
  */
object Part1 extends App {
  val source = scala.io.Source.fromResource("year2021/day08/input.txt").getLines()

  /**   0:      1:      2:      3:      4:
    *  aaaa    ....    aaaa    aaaa    ....
    * b    c  .    c  .    c  .    c  b    c
    * b    c  .    c  .    c  .    c  b    c
    *  ....    ....    dddd    dddd    dddd
    * e    f  .    f  e    .  .    f  .    f
    * e    f  .    f  e    .  .    f  .    f
    *  gggg    ....    gggg    gggg    ....
    *
    *   5:      6:      7:      8:      9:
    *  aaaa    aaaa    aaaa    aaaa    aaaa
    * b    .  b    .  .    c  b    c  b    c
    * b    .  b    .  .    c  b    c  b    c
    *  dddd    dddd    ....    dddd    dddd
    * .    f  e    f  .    f  e    f  .    f
    * .    f  e    f  .    f  e    f  .    f
    *  gggg    gggg    ....    gggg    gggg
    */

  sealed trait Digit {
    def segments: Set[Char]
  }

  object Digit {
    final case class Zero(a: Char, b: Char, c: Char, e: Char, f: Char, g: Char) extends Digit {
      val segments = Set(a, b, c, e, f, g)
    }

    final case class One(c: Char, f: Char) extends Digit {
      val segments = Set(c, f)
    }
    object One {
      def unapply(segments: Set[Char]): Boolean = segments.toArray match {
        case Array(_, _) => true
        case _           => false
      }
    }

    final case object Two   extends Digit {
      val segments = Set.empty
    }
    final case object Three extends Digit {
      val segments = Set.empty
    }

    final case class Four(b: Char, c: Char, d: Char, f: Char) extends Digit {
      val segments = Set(b, c, d, f)
    }
    object Four {
      def unapply(segments: Set[Char]): Boolean = segments.toArray match {
        case Array(_, _, _, _) => true
        case _                 => false
      }
    }

    final case object Five extends Digit {
      val segments = Set.empty
    }
    final case object Six  extends Digit {
      val segments = Set.empty
    }

    final case class Seven(a: Char, c: Char, f: Char) extends Digit {
      val segments = Set(a, c, f)
    }
    object Seven {
      def unapply(segments: Set[Char]): Boolean = segments.toArray match {
        case Array(_, _, _) => true
        case _              => false
      }
    }

    final case class Eight(a: Char, b: Char, c: Char, d: Char, e: Char, f: Char, g: Char) extends Digit {
      val segments = Set(a, b, c, d, e, f, g)
    }
    object Eight {
      def unapply(segments: Set[Char]): Boolean = segments.toArray match {
        case Array(_, _, _, _, _, _, _) => true
        case _                          => false
      }
    }

    final case object Nine extends Digit {
      val segments = Set.empty
    }
  }

  final case class Display(a: Char, b: Char, c: Char, d: Char, e: Char, f: Char, g: Char) {
    val one   = Digit.One(c, f)
    val four  = Digit.Four(b, c, d, f)
    val seven = Digit.Seven(a, c, f)
    val eight = Digit.Eight(a, b, c, d, e, f, g)

    def digit(segments: Set[Char]): Option[Digit] = segments match {
      case _ if segments == one.segments   => Some(one)
      case _ if segments == four.segments  => Some(four)
      case _ if segments == seven.segments => Some(seven)
      case _ if segments == eight.segments => Some(eight)
      case _                               => None
    }

    def digits(segments: Seq[Set[Char]]): Seq[Digit] = segments.map(digit).flatten
  }

  object Display {
    def apply(patterns: Seq[Set[Char]]): Display = {
      val state = Array.fill(10, 7)(false)

      patterns.foreach { pattern =>
        pattern match {
          case Digit.One()   => pattern.foreach(char => state(1)(char - 97) = true)
          case Digit.Four()  => pattern.foreach(char => state(4)(char - 97) = true)
          case Digit.Seven() => pattern.foreach(char => state(7)(char - 97) = true)
          case Digit.Eight() => pattern.foreach(char => state(8)(char - 97) = true)
          case _             =>
        }
      }

      val IndexedSeq(c, f) = (0 until 7).collect { case i if state(1)(i) => (i + 97).toChar }
      val IndexedSeq(b, d) = (0 until 7).collect { case i if state(1)(i) != state(4)(i) => (i + 97).toChar }
      val IndexedSeq(a)    = (0 until 7).collect { case i if state(1)(i) != state(7)(i) => (i + 97).toChar }
      val IndexedSeq(e, g) = (0 until 7).collect { case i if !state(4)(i) && !state(7)(i) => (i + 97).toChar }

      Display(a, b, c, d, e, f, g)
    }
  }

  val result = source.foldLeft(0) { (count, line) =>
    val Array(patterns, segments) = line.split('|').map(_.split(" ").filter(_.nonEmpty).map(_.toSet))

    val display = Display(patterns)
    val digits  = display.digits(segments)

    count + digits.length
  }

  println(s"How many times do digits 1, 4, 7, or 8 appear? $result")
}
