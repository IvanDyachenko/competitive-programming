package com.codeforces.contest.round1latoken

/** C. Little Alawn's Puzzle
  * - https://codeforces.com/contest/1534/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val Mod = 1000000007
  val t   = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)
    val bn = readLine().split(" ").map(_.toInt)

    val colors = Array.fill(n + 1)(0)

    val adjacent = {
      val temp = Array.fill(n + 1)(0)
      (0 until n).foreach { i => temp(an(i)) = bn(i) }
      temp
    }

    @annotation.tailrec
    def dfs(ai: Int): Unit = {
      colors(ai) = 1
      val aj = adjacent(ai)
      if (colors(aj) == 0) dfs(aj)
    }

    val ans = (1 to n).foldLeft(1) {
      case (count, ai) if colors(ai) == 0 =>
        dfs(ai)
        (count << 1) % Mod
      case (count, _)                     => count
    }

    println(ans)
  }
}
