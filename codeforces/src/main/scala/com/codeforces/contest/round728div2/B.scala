package com.codeforces.contest.round728div2

/** B. Pleasant Pairs
  * https://codeforces.com/contest/1541/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)
    val in = {
      val in = Array.fill(2 * n + 1)(0)
      an.indices.foreach(i => in(an(i)) = i)
      in
    }

    val ans = an.indices.foldLeft(0) { case (count, i) =>
      val ai = an(i)
      count + (((2 * i + 1) / ai) to ((n + i + 1) / ai)).count { aj =>
        val j = in(aj)
        j >= i + 1 && ai * aj == i + j + 2
      }
    }

    println(ans)
  }
}
