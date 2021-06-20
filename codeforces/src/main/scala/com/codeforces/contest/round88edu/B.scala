package com.codeforces.round88edu

/** B. New Theatre Square
  * - https://codeforces.com/contest/1359/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m, x, y) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val z                 = y min (2 * x)

    val ans = (0 until n).foldLeft(0) { (sum, _) =>
      val am = scala.io.StdIn.readLine().split("").map(c => if (c == ".") 1 else 0)

      val (s, t) = am.foldLeft((sum, 0)) { case ((s, l), r) =>
        if (l == 0) (s, r)
        else if (l == r) (s + z, 0)
        else (s + x, 0)
      }

      s + t * x
    }

    println(ans)

  }
}
