package com.codeforces.round656div3

/** D. a-Good String
  * - https://codeforces.com/contest/1385/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  implicit class StringOps(str: String) {
    def countSlice(from: Int, until: Int, p: Char => Boolean): Int = {
      @scala.annotation.tailrec
      def go(i: Int, c: Int = 0): Int =
        if (i == until) c
        else go(i + 1, c + (if (p(str(i))) 1 else 0))

      go(from)
    }
  }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val sn = readLine()

    def count(c: Char, from: Int, size: Int): Int =
      size match {
        case 1 =>
          if (c == sn(from)) 0 else 1
        case _ =>
          val l = sn.countSlice(from, from + size / 2, _ != c) + count((c + 1).toChar, from + size / 2, size / 2)
          val r = sn.countSlice(from + size / 2, from + size, _ != c) + count((c + 1).toChar, from, size / 2)
          l min r
      }

    val ans = count('a', 0, n)

    println(ans)
  }
}
