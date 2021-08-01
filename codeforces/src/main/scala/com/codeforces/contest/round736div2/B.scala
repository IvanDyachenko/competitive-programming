package com.codeforces.contest.round736div2

/** B. Gregor and the Pawn Game
  * https://codeforces.com/contest/1549/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val tn = readLine().split("").map(_.toInt)
    val bn = readLine().split("").map(_.toInt)

    val (ans, _, _) = (tn zip bn).foldLeft((0, 0, 0)) {
      case ((count, 1, 1), (1, 1))   => (count + 2, 0, 0)
      case ((count, 1, 1), (1, 0))   => (count + 1, 0, 0)
      case ((count, 1, 0), (1, 1))   => (count + 1, 1, 0)
      case ((count, _, _), (0, 1))   => (count + 1, 0, 0)
      case ((count, _, _), (ti, bi)) => (count, ti, bi)
    }

    println(ans)
  }
}
