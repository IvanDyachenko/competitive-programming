package com.codeforces.round640div4

/** A. Sum of Round Numbers
  * - https://codeforces.com/contest/1352/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readLine()
    val rs = n.reverse.zipWithIndex.collect { case (c, i) if c != '0' => (c - 48) * math.pow(10, i).toInt }

    println(rs.length)
    println(rs.mkString(" "))
  }
}
