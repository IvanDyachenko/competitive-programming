package com.codeforces.contest.round733div2

/** C. Pursuit
  * https://codeforces.com/contest/1530/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  def binarySearch(left: Int, right: Int, f: Int => Boolean): Int = {
    @annotation.tailrec
    def go(l: Int, r: Int): Int =
      if (l + 1 >= r) r
      else {
        val m = (l + r) / 2
        f(m) match {
          case true => go(l, m)
          case _    => go(m, r)
        }
      }

    go(left, right)
  }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt).sorted
    val bn = readLine().split(" ").map(_.toInt).sorted

    val (aprefix, bprefix) = (an.scanLeft(0)(_ + _), bn.scanLeft(0)(_ + _))

    def score(stages: Int): Boolean = {
      val considered = stages - stages / 4

      val ascore = {
        val hundreds = 0 max (stages - n)
        val defaults = 0 max (considered - hundreds)
        100 * hundreds + aprefix(n) - aprefix(n - defaults)
      }

      val bscore = bprefix(n) - bprefix(0 max (n - considered))

      ascore >= bscore
    }

    val ans =
      if (score(n)) 0
      else binarySearch(n, 2 * n, score) - n

    println(ans)
  }
}
