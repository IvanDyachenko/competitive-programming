package com.codeforces.round634div3

/** A. Candies and Two Sisters
  * - https://codeforces.com/contest/1335/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n   = scala.io.StdIn.readInt()
    val ans = (n - 1) / 2

    println(ans)
  }
}
