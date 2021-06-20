package com.codeforces.round644div3

/** E. Polygon
  * - https://codeforces.com/contest/1360/problem/E
  */
object E extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val pn = (0 until n).foldLeft(Array.ofDim[Array[Byte]](n)) { (pn, i) =>
      pn(i) = scala.io.StdIn.readLine().split("").map(_.toByte)
      pn
    }

    val ans = pn.init.zipWithIndex.forall { case (p, i) =>
      p.zip(p.tail).corresponds(pn(i + 1).init) { case ((u, r), d) =>
        u == 0 || d == 1 || r == 1
      }
    }

    if (ans) println("YES")
    else println("NO")
  }
}
