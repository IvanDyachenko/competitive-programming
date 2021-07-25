package com.codeforces.contest.round734div3

/** B1. Wonderful Coloring - 1
  * https://codeforces.com/contest/1551/problem/B1
  */
object B1 extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()

    val k = {
      val cs = Array.fill(26)(0)
      s.foreach(c => cs(c - 'a') += 1)
      cs.count(_ > 1) + cs.count(_ == 1) / 2
    }

    println(k)
  }
}
