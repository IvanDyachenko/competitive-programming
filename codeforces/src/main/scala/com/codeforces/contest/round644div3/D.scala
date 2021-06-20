package com.codeforces.round644div3

/** D. Buying Shovels
  * - https://codeforces.com/contest/1360/problem/D
  */
object D extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    val ans = n / math
      .sqrt(n)
      .toLong
      .to(1, -1)
      .collect {
        case x if n % x == 0 => List(x, n / x).filter(_ <= k)
      }
      .flatten
      .max

    println(ans)
  }
}
