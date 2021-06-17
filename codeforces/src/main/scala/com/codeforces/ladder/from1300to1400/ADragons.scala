package com.codeforces.ladder.from1300to1400

/** A. Dragons
  * - https://codeforces.com/problemset/problem/230/A
  */
object ADragons extends App {
  import scala.io.StdIn._

  val Array(s, n) = readLine().split(" ").map(_.toInt)
  val xyn         = Array
    .fill(n) {
      val Array(xi, yi) = readLine().split(" ").map(_.toInt)
      xi -> yi
    }
    .sortBy(_._1)

  val ans = {
    @annotation.tailrec
    def go(s: Int, i: Int): Boolean =
      if (i == n) true
      else if (s <= xyn(i)._1) false
      else go(s + xyn(i)._2, i + 1)

    go(s, 0)
  }

  ans match {
    case true => println("YES")
    case _    => println("NO")
  }
}
