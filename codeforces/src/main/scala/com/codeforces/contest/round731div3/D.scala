package com.codeforces.contest.round731div3

/** D. Co-growing Sequence
  * https://codeforces.com/contest/1547/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val xn = readLine().split(" ").map(_.toInt)
    val yn = (1 until n).scanLeft(0) { case (yj, i) =>
      val xj = yj ^ xn(i - 1)
      xj - (xj & xn(i))
    }

    println(yn.mkString(" "))
  }
}
