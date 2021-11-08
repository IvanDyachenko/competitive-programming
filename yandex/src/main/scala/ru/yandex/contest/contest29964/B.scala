package ru.yandex.contest.contest29964

import scala.collection.mutable

/** B. Технический долг
  * https://contest.yandex.ru/contest/29964/problems/B/
  */
object B extends App {

  def technicalDebt(period: Int, clicks: Int, deadlines: IndexedSeq[Int]): Option[Long] =
    if (deadlines.isEmpty) None
    else {
      val days   = deadlines.sorted
      val first  = days.head
      val shifts = mutable.TreeSet.empty[Int]

      def result(clicks: Int, offset: Int): Option[Long] =
        if (shifts.isEmpty) None
        else {
          val size     = shifts.size
          val count    = (clicks - 1) / size
          val position = (clicks - 1) % size

          shifts.drop(position).headOption.map { shift =>
            1L * period * (offset + count) + shift
          }
        }

      @annotation.tailrec
      def go(i: Int, clicks: Int, offset: Int = 0): Option[Long] =
        if (i == days.length) result(clicks, offset)
        else {
          val day = days(i) - first

          val shift      = day % period
          val nextOffset = day / period

          val skipped = shifts.size
          val clicked = skipped * (nextOffset - offset)

          if (clicked >= clicks)
            result(clicks, offset)
          else {
            shifts += shift
            go(i + 1, clicks - clicked, nextOffset)
          }
        }

      go(0, clicks).map(first + _)
    }

  import InOut._

  val n  = nextInt()
  val x  = nextInt()
  val k  = nextInt()
  val tn = nextInts(n)

  technicalDebt(x, k, tn) match {
    case Some(y) => out.println(y)
    case _       =>
  }
  out.flush()

  object InOut {
    import java.util.Scanner

    val in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out = new java.io.PrintWriter(System.out, false)

    def nextInt()        = Integer.parseInt(nextToken())
    def nextInts(n: Int) = Array.fill(n)(nextInt())

    def nextLong()        = java.lang.Long.parseLong(nextToken())
    def nextLongs(n: Int) = Array.fill(n)(nextLong())

    def nextBig()        = BigInt(nextToken())
    def nextBigs(n: Int) = Array.fill(n)(nextBig())

    def nextLine() = in.readLine()

    private[this] var tokenizer: java.util.StringTokenizer = _

    private[this] def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}
