package com.codeforces.contest.round733div2

/** B. Putting Plates
  * https://codeforces.com/contest/1530/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(h, w) = readLine().split(" ").map(_.toInt)

    (1 to h).foreach {
      case i if i == 1 || i == h   => println((1 to w).map(_ % 2).mkString(""))
      case i if i > 2 && i < h - 1 => println(s"${i % 2}${"0" * (w - 2)}${i % 2}")
      case _                       => println("0" * w)
    }
    println()
  }
}
