package com.codeforces.round643div2

/** B. Young Explorers
  * - https://codeforces.com/contest/1355/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val en = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val c = en.sorted
      .foldLeft((0L, 0L)) { case ((c, r), i) =>
        (c + (r + 1) / i, (r + 1) % i)
      }
      ._1

    println(c)
  }
}
