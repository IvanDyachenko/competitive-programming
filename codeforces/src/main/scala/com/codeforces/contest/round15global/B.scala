package com.codeforces.contest.round15global

/** B. Running for Gold
  * https://codeforces.com/contest/1552/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n     = readInt()
    val ranks = Array.fill(n)(readLine().split(" ").map(_.toInt))

    def compare(i: Int, j: Int): Boolean = (ranks(i) zip ranks(j)).count { case (a, b) => a <= b } >= 3

    val athlete = {
      val i = (1 until n).foldLeft(0) { (i, j) => if (compare(j, i)) j else i }
      (0 until n).forall(j => compare(i, j)) match {
        case true => Some(i)
        case _    => None
      }
    }

    athlete match {
      case Some(i) => println(i + 1)
      case _       => println(-1)
    }
  }
}
