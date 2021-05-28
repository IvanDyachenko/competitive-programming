package com.codeforces.contest.round723div2

/** C1. Potions (Easy Version)
  *   - https://codeforces.com/contest/1526/problem/C1
  */
object C1 extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toLong).toList

  val ans = {
    val cn = Array.fill[Long](n + 1, n + 1)(-1L)
    (0 to n).foreach(cn(_)(0) = 0L)

    for {
      i     <- 1 to n
      potion = an(i - 1)
      j     <- 1 to i if cn(i - 1)(j - 1) >= 0
      c      = cn(i - 1)(j - 1) + potion
    } cn(i)(j) =
      if (c >= 0) c max cn(i - 1)(j)
      else cn(i - 1)(j)

    cn(n).lastIndexWhere(_ >= 0)
  }

  println(ans)
}
