package com.codeforces.round91edu

/** C. Create The Teams
  * - https://codeforces.com/contest/1380/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse)

    val ans = an
      .foldLeft((0, 0)) { case ((count, remains), a) =>
        if (a * (remains + 1) >= x) (count + 1, 0)
        else (count, remains + 1)
      }
      ._1

    println(ans)
  }
}
