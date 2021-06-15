package com.codeforces.ladder.from0to1300

/** A. Ultra-Fast Mathematician
  * - https://codeforces.com/problemset/problem/61/A
  */
object AUltraFastMathematician extends App {
  import scala.io.StdIn._

  val a = readLine()
  val b = readLine()

  val ans = (a zip b).map { case (x, y) => x ^ y }.mkString("")

  println(ans)
}
