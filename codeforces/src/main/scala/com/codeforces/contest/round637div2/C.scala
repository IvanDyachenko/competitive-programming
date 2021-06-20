package com.codeforces.round637div2

/** C. Nastya and Strange Generator
  * - https://codeforces.com/contest/1341/problem/C
  */
object C extends App {
  import scala.io.StdIn._
  import scala.annotation.tailrec

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val pn = readLine().split(" ").map(_.toInt)

    @tailrec
    def check(p: Int, from: Int = 0): Boolean =
      if (from >= n - 1) true
      else {
        val to     = pn.indexOf(p, from)
        val status = (from until to).forall(i => pn(i) == p - to + i)

        if (status) check(pn(from) - 1, to + 1)
        else false
      }

    val ans = check(n)

    if (ans) println("Yes")
    else println("No")
  }
}
