package com.codeforces.round650div3

/** B. Even Array
  * - https://codeforces.com/contest/1367/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val (even, odd) = an.zipWithIndex.foldLeft((0, 0)) { case ((even, odd), (a, i)) =>
      if (a % 2 == i % 2) (even, odd)
      else if (i % 2 == 0) (even + 1, odd)
      else (even, odd + 1)
    }

    val ans =
      if (even != odd) -1
      else odd

    println(ans)
  }
}
