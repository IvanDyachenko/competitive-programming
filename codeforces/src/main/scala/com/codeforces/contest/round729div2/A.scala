package com.codeforces.contest.round729div2

/** A. Odd Set
  * https://codeforces.com/contest/1542/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans = n == an.count(_ % 2 == 1)

    ans match {
      case true => println("Yes")
      case _    => println("No")
    }
  }
}
