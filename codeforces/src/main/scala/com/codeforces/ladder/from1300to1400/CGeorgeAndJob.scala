package com.codeforces.ladder.from1300to1400

/** C. George and Job
  * - https://codeforces.com/problemset/problem/467/C
  */
object CGeorgeAndJob extends App {
  import scala.io.StdIn._

  val Array(n, m, k) = readLine().split(" ").map(_.toInt)
  val p              = readLine().split(" ").map(_.toInt)

  val ans = {
    val psum = p.scanLeft(0L)(_ + _)
    val dp   = Array.fill(k + 1, n + 1)(0L)

    (1 to k).foreach { i =>
      (1 to n).foreach { j =>
        if (i * m <= j) {
          dp(i)(j) = dp(i)(j - 1) max (dp(i - 1)(j - m) + psum(j) - psum(j - m))
        }
      }
    }

    dp(k)(n)
  }

  println(ans)
}
