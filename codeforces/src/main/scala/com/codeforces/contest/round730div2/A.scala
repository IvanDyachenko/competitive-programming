package com.codeforces.contest.round730div2

/** A. Exciting Bets
  * https://codeforces.com/contest/1543/problem/A
  *
  * gcd(a, b) = gcd(a - b, b), a > b
  * gcd(a, b) <= min(a, b)
  *
  * gcd(a - b, b) <= min(a - b, b)
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(a, b) = readLine().split(" ").map(_.toLong).sorted

    val e = b - a
    val m =
      if (e == 0) 0
      else if (a % e == b % e) (a % e) min (e - a % e)
      else a

    println(s"$e $m")
  }
}
