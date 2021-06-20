package com.codeforces.round656div3

/** A. Three Pairwise Maximums
  * - https://codeforces.com/contest/1385/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(x, y, z) = readLine().split(" ").map(_.toInt)

    val ans =
      if (x == y && x >= z) Some((x, z, z))
      else if (x == z && x >= y) Some((y, x, y))
      else if (y == z && y >= x) Some((x, x, y))
      else None

    ans match {
      case Some((a, b, c)) => println(s"YES\n$a $b $c")
      case _               => println("NO")
    }
  }
}
