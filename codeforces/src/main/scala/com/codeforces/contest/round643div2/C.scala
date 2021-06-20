package com.codeforces.round643div2

/** C. Count Triangles
  * - https://codeforces.com/contest/1355/problem/C
  */
object C extends App {
  val Array(a, b, c, d) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val pref = (a to b)
    .foldLeft(Array.fill[Int](b + c + 2)(0)) { (pref, x) =>
      pref(x + b) += 1
      pref(x + c + 1) -= 1
      pref
    }
    .scanLeft(0L)(_ + _)
    .tail
    .scanRight(0L)(_ + _)

  val ans = (c to d.min(b + c)).foldLeft(0L)((s, z) => s + pref(z + 1))

  println(ans)
}
