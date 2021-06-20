package com.codeforces.round648div2

/** A. Matrix Game
  * - https://codeforces.com/contest/1365/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val (row, col) = (0 until n).foldLeft((List.fill(m)(0), List.empty[Int])) { case ((row, col), _) =>
      val a = scala.io.StdIn.readLine().split(" ").map(_.toInt)

      (row.zip(a).map { case (p, q) => p + q }, a.sum :: col)
    }

    val free = row.count(_ == 0) min col.count(_ == 0)

    val ans =
      if (free % 2 == 0) "Vivek"
      else "Ashish"

    println(ans)
  }
}
