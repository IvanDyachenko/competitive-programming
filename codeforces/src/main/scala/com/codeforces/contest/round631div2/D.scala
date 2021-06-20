package com.codeforces.round631div2

/** D. Dreamoon Likes Sequences
  * - https://codeforces.com/contest/1330/problem/D https://codeforces.com/blog/entry/75559
  */
object D extends App {
  case class Case(d: Int, m: Int)

  implicit def arr2case(arr: Array[Int]): Case = arr match {
    case Array(d, m) => Case(d, m)
    case _           => throw new IllegalArgumentException
  }

  private def numberOfChoices(c: Case): Long = {
    val Case(d, m) = c

    val r = Stream
      .iterate(0)(_ + 1)
      .takeWhile(i => (1 << i) <= d)
      .foldLeft(1L) { (acc, i) =>
        val l = 1 << i
        val r = d min ((l << 1) - 1)

        (acc * (r - l + 2) % m)
      } - 1

    if (r < 0) r + m
    else r
  }

  val t = scala.io.StdIn.readInt()

  val cs = (0 until t)
    .foldLeft(List.empty[Case]) { (cs, _) =>
      val c = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      c :: cs
    }
    .reverse

  val ns = cs.map(numberOfChoices)

  ns.foreach(println)
}
