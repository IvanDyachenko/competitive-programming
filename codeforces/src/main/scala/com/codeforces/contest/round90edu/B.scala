package com.codeforces.round90edu

/** B. 01 Game
  * - https://codeforces.com/contest/1373/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()

    val c1 = s.count(_ == '1')
    val c2 = s.length - c1

    val c = c1 min c2

    if (c % 2 == 0) println("NET")
    else println("DA")
  }
}
