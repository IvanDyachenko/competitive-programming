package com.codeforces.contest.round723div2

/** B. I Hate 1111
  *   - https://codeforces.com/contest/1526/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  /** 11
    * 111
    * 1111 = 11 * 101
    * 11111 = 111 * 100 + 11
    * 111111 = 1111 * 100 + 11
    * ...
    *
    * x = 111 * a + 11 * b, a>=0, b>=0
    * a = 11 * c + d, c>=0, d<11
    * x = 111 * (11 * c + d) + 11 * b, c>=0, b>=0, d<11
    * x = 11 * (111 * c + b) + 111 * d, c>=0, b>=0, d<11
    *
    * @param x
    * @return
    */
  @annotation.tailrec
  private def check(x: Int): Boolean = (x >= 0) && ((x % 11 == 0) || check(x - 111))

  val t = readInt()

  (0 until t).foreach { _ =>
    val x = readInt()

    val ans = check(x) match {
      case true => "YES"
      case _    => "NO"
    }

    println(ans)
  }
}
