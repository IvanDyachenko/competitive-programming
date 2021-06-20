package com.codeforces.round650div3

/** A. Short Substrings
  * - https://codeforces.com/contest/1367/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val b = readLine()
    val a = b.head + b.indices.tail.by(2).map(b).mkString

    println(a)
  }
}
