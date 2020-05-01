package com.codeforces.round638div2

object A extends App {
  val t = scala.io.StdIn.readInt()

  private def prefix(i: Int): Long = (1L << (i + 1)) - 2L

  (0 until t).foreach { _ =>
    val n = scala.io.StdIn.readInt()

    val b = (1L << n) + prefix(n / 2 - 1)
    val a = prefix(n - 1) - prefix(n / 2 - 1)

    val ans = b - a

    println(ans)
  }
}
