package com.codeforces.round90edu

/** D. Maximum Sum on Even Positions
  * - https://codeforces.com/contest/1373/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  def kadane(an: Seq[Int]): Long = an match {
    case a +: _ =>
      an.foldLeft((a.toLong, 0L)) { case ((subSum, partSum), a) =>
        (subSum max (partSum + a), 0L max (partSum + a))
      }._1
    case _      => 0L
  }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans = n match {
      case 1 => an.head
      case _ =>
        val evens = an.zipWithIndex.collect { case (a, i) if i % 2 == 0 => a }
        val base  = evens.foldLeft(0L)(_ + _)
        val odds  = an.zipWithIndex.collect { case (a, i) if i % 2 == 1 => a }

        val d1 = evens.zip(odds).map { case (e, o) => o - e }
        val d2 = odds.zip(evens.tail).map { case (o, e) => o - e }

        val profit = 0L max kadane(d1) max kadane(d2)

        base + profit
    }

    println(ans)
  }
}
