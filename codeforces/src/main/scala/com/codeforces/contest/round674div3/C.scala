package com.codeforces.contest.round674div3

/** C. Increase and Copy
  * - https://codeforces.com/contest/1426/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n = readInt()

    @annotation.tailrec
    def go(i: Int): Int = {
      val j = (n + i - 1) / i

      if (i > j) go(i + 1) else i + j - 2
    }

    val ans = go(1)

    println(ans)
  }
}
