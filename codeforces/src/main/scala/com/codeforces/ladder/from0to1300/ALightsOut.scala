package com.codeforces.ladder.from0to1300

/** A. Lights Out
  * - https://codeforces.com/problemset/problem/275/A
  */
object ALightsOut extends App {
  import scala.io.StdIn._

  val m = Array.fill(3)(readLine().split(" ").map(_.toInt))

  def light(pos: (Int, Int)): Int = pos match {
    case (i, j) =>
      if (i < 0 || i > 2 || j < 0 || j > 2) 0
      else m(i)(j)
  }

  def isSwitchedOn(i: Int, j: Int): Boolean =
    List((i, j), (i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1))
      .foldLeft(0)(_ + light(_)) % 2 == 0

  (0 to 2).foreach { i =>
    (0 to 2).foreach(j => if (isSwitchedOn(i, j)) print("1") else print("0"))
    println()
  }
}
