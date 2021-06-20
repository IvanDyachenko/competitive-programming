package com.codeforces.contest.round671div2

/** A. Digit Game
  * - https://codeforces.com/contest/1419/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split("").map(_.toInt)

    val ans =
      if (n % 2 == 0) {
        val b = an.zipWithIndex.exists { case (a, i) => (i + 1) % 2 == 0 && a % 2 == 0 }

        if (b) 2 else 1
      } else {
        val r = an.zipWithIndex.exists { case (a, i) => (i + 1) % 2 == 1 && a % 2 == 1 }

        if (r) 1 else 2
      }

    println(ans)
  }
}
