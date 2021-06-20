package com.codeforces.contest.round671div2

/** C. Killjoy
  * - https://codeforces.com/contest/1419/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt - x)

    val ans =
      if (an.forall(_ == 0)) 0
      else if (an.sum == 0 || an.contains(0)) 1
      else 2

    println(ans)
  }
}
