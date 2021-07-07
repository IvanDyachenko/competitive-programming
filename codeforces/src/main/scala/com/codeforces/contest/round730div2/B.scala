package com.codeforces.contest.round730div2

/** B. Customising the Track
  * https://codeforces.com/contest/1543/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val c = an.foldLeft(0L)(_ + _) % n

    val ans = c * (n - c)

    println(ans)
  }
}
