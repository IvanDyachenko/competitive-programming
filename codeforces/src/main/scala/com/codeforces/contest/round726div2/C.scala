package com.codeforces.contest.round726div2

/** C. Challenging Cliffs
  * - https://codeforces.com/contest/1537/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val hn = readLine().split(" ").map(_.toInt).sorted

    val i = (1 until (n - 1)).foldLeft(0) {
      case (i, j) if math.abs(hn(j) - hn(j + 1)) < math.abs(hn(i) - hn(i + 1)) => j
      case (i, _)                                                              => i
    }

    // h1 h2 h3 ... hi hi+1 ... hn
    //
    // The first variant (incorrect):
    //   hi+1 ... hn h1 h2 h3 ... hi
    //   Example:
    //     -> 1 3
    //     <- 3 1
    //
    // The second variant (correct):
    //  hi hi+2 ... hn h1 h2 ... hi+1
    //  Example
    //    -> 1 3
    //    <- 1 3

    val ans = hn(i) +: (((i + 2) until n).map(hn) ++ (0 until i).map(hn)) :+ hn(i + 1)

    println(ans.mkString(" "))
  }
}
