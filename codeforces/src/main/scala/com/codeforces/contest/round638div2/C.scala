package com.codeforces.round638div2

/** C. Phoenix and Distribution
  * - https://codeforces.com/contest/1348/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val s           = scala.io.StdIn.readLine().sorted

    val ans =
      if (s(0) != s(k - 1) || k == n) s(k - 1).toString
      else if (s(k) != s(n - 1)) s(0).toString + s.slice(k, n)
      else s(0) + s(k).toString * ((n - 1) / k)

    println(ans)
  }
}
