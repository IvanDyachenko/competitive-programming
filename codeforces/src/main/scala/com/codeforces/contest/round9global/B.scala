package com.codeforces.round9global

/** B. Neighbor Grid
  * - https://codeforces.com/contest/1375/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val base        = if (n == 1 || m == 1) 3 else 4

    var check = true

    val b = (0 until n).map { i =>
      val input = readLine().split(" ").map(_.toInt)
      val row   = (0 until m).map(j => base - (if (i == 0 || i == n - 1) 1 else 0) - (if (j == 0 || j == m - 1) 1 else 0))

      check &&= input.zip(row).forall { case (x, y) => x <= y }

      row
    }

    if (check) {
      println("YES")
      println(b.map(_.mkString(" ")).mkString("\n"))
    } else println("NO")
  }
}
