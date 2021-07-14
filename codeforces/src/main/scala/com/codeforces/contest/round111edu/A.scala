package com.codeforces.contest.round111edu

/** A. Find The Array
  * https://codeforces.com/contest/1550/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  def f: Int => Int = x => math.ceil(math.sqrt(x)).toInt

  val t = readInt()

  (0 until t).foreach { _ =>
    val x = readInt()
    println(f(x))
  }
}
