package com.codeforces.ladder.from1300to1400

/** B. Books
  * https://codeforces.com/problemset/problem/279/B
  */
object BBooks extends App {
  import scala.io.StdIn._

  val Array(n, t) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt)
  val tn          = an.scanLeft(0)(_ + _)

  /** [i, j)
    */
  @annotation.tailrec
  def go(i: Int, j: Int, c: Int = 0, r: Int = 0): Int =
    if (i == n || j == n + 1) r
    else if (i == j) go(i, j + 1, 0, r)
    else {
      val ti = tn(j) - tn(i)
      if (t >= ti) go(i, j + 1, c + 1, r max (c + 1))
      else go(i + 1, j, c - 1, r)
    }

  val ans = go(0, 1)

  println(ans)
}
