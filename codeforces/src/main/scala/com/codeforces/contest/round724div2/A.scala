package com.codeforces.contest.round724div2

/** A. Omkar and Bad Story
  * - https://codeforces.com/contest/1536/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val (h, l) = (an.min, an.max)

    val bn =
      if (h.signum >= 0) Some(0 to l)
      else None

    bn match {
      case Some(value) =>
        println("YES")
        println(value.length)
        println(value.mkString(" "))
      case _           =>
        println("NO")
    }
  }
}
