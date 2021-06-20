package com.codeforces.round650div3

/** C. Social Distance
  * - https://codeforces.com/contest/1367/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val sn          = readLine().split("").map(_.toInt)

    val (ans, _) = (sn.zipWithIndex.collect { case (x, i) if x == 1 => i } :+ (n + k)).foldLeft((0, -k - 1)) {
      case ((c, l), r) =>
        (c + (r - l - 1 - k).max(0) / (k + 1), r)
    }

    println(ans)
  }
}
