package com.codeforces.contest.deltix2021summer

/** B. Take Your Places!
  * https://codeforces.com/contest/1556/problem/B
  */
object B extends App {

  def swaps(an: IndexedSeq[Int]): Option[Int] = {
    val odds = an.indices.collect { case i if an(i) % 2 == 1 => i }

    def count(startIndex: Int): Int =
      (odds zip (startIndex to (an.length, 2))).foldLeft(0) { case (c, (j, i)) => c + math.abs(i - j) }

    (odds.length, an.length - odds.length) match {
      case (ol, el) if ol == el     => Some(count(0) min count(1))
      case (ol, el) if ol == el + 1 => Some(count(0))
      case (ol, el) if el == ol + 1 => Some(count(1))
      case _                        => None
    }
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    swaps(an) match {
      case Some(count) => println(count)
      case None        => println(-1)
    }
  }

}
