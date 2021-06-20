package com.codeforces.round647div2

/** C. Johnny and Another Rating Drop
  * - https://codeforces.com/contest/1362/problem/C
  */
object C extends App {

  private def count(n: Long): Long = {

    @scala.annotation.tailrec
    def go(n: Long, c: Long): Long =
      if (n == 0L) c
      else {
        val k = (1 to 63).collectFirst { case i if n < (1L << i) => i }.getOrElse(0) - 1
        go(n & ~(1L << k), c - 1L + (1L << (k + 1)))
      }

    go(n, 0L)
  }

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n   = scala.io.StdIn.readLong()
    val ans = count(n)

    println(ans)
  }
}
