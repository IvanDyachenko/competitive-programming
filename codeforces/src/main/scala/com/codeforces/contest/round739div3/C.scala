package com.codeforces.contest.round739div3

/** C. Infinity Table
  * https://codeforces.com/contest/1560/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val k = readInt()

    val i = {
      @annotation.tailrec
      def go(i: Int): Int = if (i * i >= k) i else go(i + 1)
      go(1)
    }
    val j = k - (i - 1) * (i - 1)

    val (r, c) = if (j <= i) (j, i) else (i, i - (j - i))

    println(s"$r $c")
  }
}
