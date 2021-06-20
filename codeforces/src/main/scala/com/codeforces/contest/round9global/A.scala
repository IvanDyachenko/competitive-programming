package com.codeforces.round9global

/** A. Sign Flipping
  * - https://codeforces.com/contest/1375/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val bn = an.zipWithIndex.map { case (a, i) => if (i % 2 == 0) a.abs else -a.abs }

    println(bn.mkString(" "))
  }
}
