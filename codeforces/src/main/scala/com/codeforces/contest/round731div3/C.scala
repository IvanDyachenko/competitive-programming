package com.codeforces.contest.round731div3

/** C. Pair Programming
  * https://codeforces.com/contest/1547/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    readLine()
    val Array(k, n, m) = readLine().split(" ").map(_.toInt)
    val an             = readLine().split(" ").map(_.toInt)
    val bm             = readLine().split(" ").map(_.toInt)

    @annotation.tailrec
    def go(i: Int, j: Int, l: Int, ops: List[Int]): Option[List[Int]] =
      if (i == n && j == m) Some(ops)
      else if (i != n && an(i) == 0) go(i + 1, j, l + 1, 0 :: ops)
      else if (j != m && bm(j) == 0) go(i, j + 1, l + 1, 0 :: ops)
      else if (i != n && an(i) <= l) go(i + 1, j, l, an(i) :: ops)
      else if (j != m && bm(j) <= l) go(i, j + 1, l, bm(j) :: ops)
      else None

    go(0, 0, k, List.empty[Int]) match {
      case Some(ops) => println(ops.reverse.mkString(" "))
      case _         => println(-1)
    }
  }
}
