package com.codeforces.round85edu

/** C. Circle of Monsters
  * - https://codeforces.com/contest/1334/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  var hs = Array.ofDim[Long](300000)
  var es = Array.ofDim[Long](300000)

  val t = readInt()

  (0 until t).foreach { _ =>
    val n = readInt()

    (0 until n).foreach { i =>
      val Array(h, e) = readLine().split(" ").map(_.toLong)
      hs(i) = h
      es(i) = e
    }

    val (bs, b) = (0 until n).foldLeft((0L, Long.MaxValue)) { case ((bs, b), i) =>
      val j = if (i + 1 == n) 0 else i + 1
      val a = hs(j) min es(i)

      (bs + hs(j) - a, b min a)
    }

    val ans = bs + b

    println(ans)
  }
}
