package com.codeforces.contest.deltix2021summer

/** A. A Variety of Operations
  * https://codeforces.com/contest/1556/problem/A
  */
object A extends App {

  def operations: (Int, Int) => Int = (_, _) match {
    case (0, 0)           => 0
    case (c, d) if c == d => 1
    case (c, d) if math.abs(c - d) % 2 == 0 => 2
    case _ => -1
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(c, d) = readLine().split(" ").map(_.toInt)

    println(operations(c, d))
  }

}
