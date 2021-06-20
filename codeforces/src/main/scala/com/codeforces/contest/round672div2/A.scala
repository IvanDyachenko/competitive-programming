package com.codeforces.contest.round672div2

/** A. Cubes Sorting
  * - https://codeforces.com/contest/1420/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").view.map(_.toInt)

    val status = (an zip an.tail).exists { case (a, b) => a <= b }

    val ans = status match {
      case true => "YES"
      case _    => "NO"
    }

    println(ans)
  }
}
