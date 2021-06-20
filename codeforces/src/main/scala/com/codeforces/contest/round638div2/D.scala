package com.codeforces.round638div2

/** D. Phoenix and Science
  * - https://codeforces.com/contest/1348/problem/D
  */
object D extends App {
  val t = scala.io.StdIn.readInt()

  private def days(n: Int): Seq[Int] = {
    val ds = Stream.iterate(1)(_ << 1).takeWhile(_ << 1 < n + 1)

    val d = n + 1 - (1 << ds.length)

    (d +: ds).sorted.sliding(2).flatMap { case Seq(a, b) => Seq(b - a) }.toSeq
  }

  (0 until t).foreach { _ =>
    val n = scala.io.StdIn.readInt()

    val ds = days(n)

    println(ds.length)
    println(s"${ds.mkString(" ")}")
  }
}
