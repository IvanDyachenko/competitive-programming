package com.codeforces.round634div3

/** B. Construct the String
  * - https://codeforces.com/contest/1335/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, _, b) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val s              = (0 until n).map(i => ('a' + i % b).toChar).mkString("")

    println(s)
  }
}
