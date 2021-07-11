package com.codeforces.contest.round731div3

/** B. Alphabetical Strings
  * https://codeforces.com/contest/1547/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()
    val n = s.length

    @annotation.tailrec
    def go(l: Int, r: Int): Boolean =
      if (l == 0 && r == n - 1) true
      else if (l < 0 || r > n - 1) false
      else {
        val c = (s(l) max s(r)) + 1

        if (l > 0 && s(l - 1) == c) go(l - 1, r)
        else if (r < n - 1 && s(r + 1) == c) go(l, r + 1)
        else false
      }

    val a = s.indexWhere(_ == 'a')

    go(a, a) match {
      case true => println("yes")
      case _    => println("no")
    }

  }
}
