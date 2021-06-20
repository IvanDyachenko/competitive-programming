package com.codeforces.round91edu

/** B. Universal Solution
  * - https://codeforces.com/contest/1380/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val winBy = Map.apply('S' -> 'R', 'R' -> 'P', 'P' -> 'S')

  val t = readInt()

  (0 until t).foreach { _ =>
    val sn = readLine()

    val ans = winBy(sn.groupBy(identity).maxBy(_._2.size)._1).toString * sn.size

    println(ans)
  }
}
