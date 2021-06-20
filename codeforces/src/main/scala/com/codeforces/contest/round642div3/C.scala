package com.codeforces.round642div3

/** C. Board Moves
  * - https://codeforces.com/contest/1353/problem/C
  */
object C extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n = scala.io.StdIn.readInt()

    val m   = (n - 1L) / 2L
    val ans = m * (m + 1L) / 6L * (2L * m + 1) * 8L

    println(ans)
  }
}
