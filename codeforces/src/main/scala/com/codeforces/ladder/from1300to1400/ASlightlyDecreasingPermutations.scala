package com.codeforces.ladder.from1300to1400

/** A. Slightly Decreasing Permutations
  * - https://codeforces.com/problemset/problem/285/A
  */
object ASlightlyDecreasingPermutations extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)

  val ans = (n until (n - k, -1)) ++ (1 to (n - k))

  println(ans.mkString(" "))
}
