package com.codeforces.ladder.from1300to1400

/** A. The number of positions
  * - https://codeforces.com/problemset/problem/124/A
  */
object ATheNumberOfPositions extends App {
  import scala.io.StdIn._

  val Array(n, a, b) = readLine().split(" ").map(_.toInt)

  val ans = n - (a + 1) max (n - b) + 1

  println(ans)
}
