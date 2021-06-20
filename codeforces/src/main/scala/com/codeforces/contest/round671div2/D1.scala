package com.codeforces.contest.round671div2

/** D1. Sage's Birthday (easy version)
  * - https://codeforces.com/contest/1419/problem/D1
  */
object D1 extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse)

  val bn = Array.ofDim[Int](n)

  bn(0) = an(0)
  (1 until n).foreach {
    case i if i % 2 == 0 => bn(i) = an(i - 1)
    case i => bn(i) = an((n - 1) min (i + 1))
  }

  println((n - 1) / 2)
  println(bn.mkString(" "))
}
