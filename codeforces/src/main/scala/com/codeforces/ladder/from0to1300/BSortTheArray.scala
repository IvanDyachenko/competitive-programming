package com.codeforces.ladder.from0to1300

/** B. Sort the Array
  * - https://codeforces.com/problemset/problem/451/B
  */
object BSortTheArray extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt)

  val ans = {
    val l = (1 until n).collectFirst { case i if an(i) < an(i - 1) => i - 1 }.getOrElse(0)
    val r = (l until n).collectFirst { case j if an(j) > an(l) => j - 1 }.getOrElse(n - 1)

    def ai(i: Int): Int = if (i >= l && i <= r) an(l + r - i) else an(i)

    val check = (1 until n).forall(i => ai(i) > ai(i - 1))

    if (check) Some(l -> r) else None
  }

  ans match {
    case Some((l, r)) =>
      println("yes")
      println(s"${l + 1} ${r + 1}")
    case _            =>
      println("no")
  }
}
