package com.codeforces.contest.deltix2021spring

/** C. Compression and Expansion
  * - https://codeforces.com/contest/1523/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = Array.fill(n)(readShort())

    def go(level: List[Short], i: Int): Unit =
      if (i == n) ()
      else {
        val ai   = an(i)
        val next =
          if (ai == 1) (1: Short) :: level
          else if (ai == level.head + 1) ai :: level.tail
          else ai :: level.dropWhile(_ + 1 != ai).tail

        println(next.reverse.mkString("."))

        go(next, i + 1)
      }

    go(Nil, 0)
  }
}
