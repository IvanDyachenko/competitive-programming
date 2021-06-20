package com.codeforces.round631div2

/** B. Dreamoon Likes Permutations
  * - https://codeforces.com/contest/1330/problem/B
  */
object B extends App {

  private def restore(as: List[Int]): List[(Int, Int)] = {
    val n  = as.length
    val ma = as.max

    List(ma, n - ma)
      .foldLeft(List.empty[(Int, Int)]) { case (ls, i) =>
        val (l1, l2) = (i, n - i)

        val (q1, q2) = as.splitAt(i)
        val (p1, p2) = (q1.distinct, q2.distinct)

        if (
          p1.length == l1 && p1.min == 1 && p1.max == l1 &&
          p2.length == l2 && p2.min == 1 && p2.max == l2
        )
          (l1, l2) :: ls
        else
          ls
      }
      .distinct
  }

  val t = scala.io.StdIn.readInt()

  val input: List[List[Int]] = (0 until t)
    .foldLeft(List.empty[List[Int]]) { (input, _) =>
      val n  = scala.io.StdIn.readInt()
      val as = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

      as :: input
    }
    .reverse

  val output = input.map(restore)

  output.foreach { ls =>
    println(ls.length)
    if (ls.nonEmpty) ls.foreach { case (l1, l2) => println(s"$l1 $l2") }
  }
}
