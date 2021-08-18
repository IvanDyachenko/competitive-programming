package com.codeforces.contest.round739div3

/** A. Dislike of Threes
  * https://codeforces.com/contest/1560/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  lazy val xn = Stream.iterate(1)(_ + 1).filterNot(x => x % 3 == 0 || x % 10 == 3)

  val t = readInt()

  (0 until t).foreach { _ =>
    val k = readInt()

    val ans = xn(k - 1)

    println(ans)
  }
}
