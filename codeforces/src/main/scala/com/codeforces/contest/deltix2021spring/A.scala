package com.codeforces.contest.deltix2021spring

/** A. Game of Life
  * - https://codeforces.com/contest/1523/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val state       = readLine().split("").map(_.toInt)

    def go(i: Int): Boolean =
      if (i == 0) false
      else {
        var flag = false

        for {
          j <- 0 until n if state(j) == 0
          l  = if (j == 0) 0 else state(j - 1)
          r  = if (j + 1 == n) 0 else state(j + 1)
          sj = l ^ r if sj != state(j)
        } {
          flag = true
          state(j) = sj
        }

        flag && go(i - 1)
      }

    go(m)

    println(state.mkString(""))
  }
}
