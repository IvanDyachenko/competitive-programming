package com.codeforces.ladder.from1300to1400

/** A. Dima and Continuous Line
  * https://codeforces.com/contest/358/problem/A
  */
object ADimaAndContinuousLine extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val xn = readLine().split(" ").map(_.toInt)

  @annotation.tailrec
  def solve(i: Int, j: Int): Boolean =
    if (i > n - 2) false
    else if (j > n - 2) solve(i + 1, i + 1)
    else {
      val (xi, yi) = (xn(i) min xn(i + 1), xn(i) max xn(i + 1))
      val (xj, yj) = (xn(j) min xn(j + 1), xn(j) max xn(j + 1))

      if (xi < xj && xj < yi && yi < yj || xj < xi && xi < yj && yj < yi) true
      else solve(i, j + 1)
    }

  solve(0, 0) match {
    case true => println("yes")
    case _    => println("no")
  }
}
