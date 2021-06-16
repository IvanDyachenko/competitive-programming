package com.codeforces.ladder.from1300to1400

/** B. Present from Lena
  * - https://codeforces.com/problemset/problem/118/B
  */
object BPresentFromLena extends App {
  import scala.io.StdIn._

  val n = readInt()

  val ans = {
    val r = (n to (0, -1)).map { i =>
      val l = (n to (0, -1)).collect { case j if j <= i => j }
      " " * 2 * (n - i) + (l.tail.reverse ++ l).mkString(" ")
    }

    (r.tail.reverse ++ r).mkString("\n")
  }

  println(ans)
}
