package com.codeforces.ladder.from1300to1400

/** C. k-Tree
  * https://codeforces.com/problemset/problem/431/C
  */
object CkTree extends App {
  import scala.io.StdIn._

  val Mod            = (1e9 + 7).toInt
  val Array(n, k, d) = readLine().split(" ").map(_.toInt)

  // dp(i)(j) where i - the total weight of the path,
  //                j - the sign of the fact that all edges less than d.

  val ans = {
    val dp = Array.fill(n + 1, 2)(0)

    def add(a: Int, b: Int): Int = (a + b) % Mod

    dp(0)(0) = 1

    for {
      i <- 1 to n
      j <- 1 to k
      if i - j >= 0
    } if (j < d) {
      dp(i)(0) = add(dp(i)(0), dp(i - j)(0))
      dp(i)(1) = add(dp(i)(1), dp(i - j)(1))
    } else {
      dp(i)(1) = add(dp(i)(1), dp(i - j)(0))
      dp(i)(1) = add(dp(i)(1), dp(i - j)(1))
    }

    dp(n)(1)
  }

  println(ans)
}
