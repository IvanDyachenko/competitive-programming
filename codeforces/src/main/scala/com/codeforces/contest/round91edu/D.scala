package com.codeforces.round91edu

/** D. Berserk And Fireball
  * - https://codeforces.com/contest/1380/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  val Array(n, m)    = readLine().split(" ").map(_.toInt)
  val Array(x, k, y) = readLine().split(" ").map(_.toLong)
  val cheap          = x.min(y * k)
  val an             = readLine().split(" ").map(_.toInt) :+ 0
  val bn             = readLine().split(" ").map(_.toInt) :+ 0

  private def destroy(from: Int, until: Int): Long = {
    val range = until - from
    val count = range / k
    val over  = range % k

    val warrior   = if (from == 0) an(until) else an(until).max(an(from - 1))
    val i         = an.indexWhere(_ > warrior, from)
    val j         = if (i == -1) until else until.min(i)
    val strongest = an(j)

    if (strongest > warrior) {
      if (count == 0 && over != 0) -1L
      else x + y * over + cheap * (count - 1)
    } else y * over + cheap * count
  }

  val ans = bn
    .foldLeft((0L, 0)) {
      case ((-1L, _), _)       => (-1L, 0)
      case ((amount, from), b) =>
        val until = an.indexOf(b, from)

        if (until == -1) (-1L, 0)
        else {
          val cost = destroy(from, until)

          if (cost == -1L) (-1L, 0)
          else (amount + cost, until + 1)
        }
    }
    ._1

  println(ans)
}
