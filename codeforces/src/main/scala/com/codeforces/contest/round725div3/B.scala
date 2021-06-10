package com.codeforces.contest.round725div3

/** B. Friends and Candies
  * - https://codeforces.com/contest/1538/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toLong)

    val s = an.sum

    val ans =
      if (s % n != 0) -1
      else {
        val g = s / n
        an.count(_ > g)
      }

    println(ans)
  }
}
