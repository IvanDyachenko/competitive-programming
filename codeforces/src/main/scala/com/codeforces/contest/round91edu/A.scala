package com.codeforces.round91edu

/** A. Three Indices
  * - https://codeforces.com/contest/1380/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val pn = readLine().split(" ").map(_.toInt)

    val ans = (0 until n - 2).collectFirst {
      case i if pn(i) < pn(i + 1) && pn(i + 2) < pn(i + 1) => (i + 1, i + 2, i + 3)
    }

    ans match {
      case Some((i, j, k)) => println(s"YES\n$i $j $k")
      case _               => println("NO")
    }
  }
}
