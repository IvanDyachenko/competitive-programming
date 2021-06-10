package com.codeforces.contest.round725div3

/** C. Number of Pairs
  * - https://codeforces.com/contest/1538/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  @annotation.tailrec
  private def binary(p: Int, q: Int, f: Int => Boolean): Int =
    if (p + 1 >= q) q
    else {
      val o = (p + q) / 2

      f(o) match {
        case true  => binary(o, q, f)
        case false => binary(p, o, f)
      }
    }

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, l, r) = readLine().split(" ").map(_.toInt)
    val an             = readLine().split(" ").map(_.toInt).sorted

    val ans = (0 until n).foldLeft(0L) { case (count, i) =>
      val ai = an(i)

      val p = binary(i, n, an(_) + ai <= r)
      val q = binary(i, n, an(_) + ai <= l - 1)

      count + p - q
    }

    println(ans)
  }
}
