package com.codeforces.contest.round727div2

/** C. Stable Groups
  * https://codeforces.com/contest/1539/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val Array(_, k, x) = readLine().split(" ").map(_.toLong)
  val an             = readLine().split(" ").map(_.toLong).sorted
  val n              = an.length

  val indices = for {
    i <- 0 until (n - 1) if an(i + 1) > x + an(i)
  } yield i
  val weights = indices.map(i => (an(i + 1) - an(i) + x - 1) / x - 1).sorted

  @annotation.tailrec
  def go(k: Long, weights: Seq[Long]): Long =
    weights match {
      case weight +: weights if k - weight >= 0 => go(k - weight, weights)
      case _                                    => weights.length + 1
    }

  val ans = go(k, weights)

  println(ans)
}
