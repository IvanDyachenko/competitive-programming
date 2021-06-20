package com.codeforces.round631div2

/** A. Dreamoon and Ranking Collection
  * - https://codeforces.com/contest/1330/problem/A
  */
object A extends App {
  class Rank private (val x: Int, val as: List[Int])

  object Rank {
    def apply(x: Int, as: List[Int]): Rank            = new Rank(x, as.distinct.sorted)
    def unapply(rank: Rank): Option[(Int, List[Int])] = Some(rank.x, rank.as)
  }

  private def possible(r: Rank): Int = {
    val Rank(x, as) = r

    val t = as.foldLeft((0, x)) { case ((i, x), j) =>
      if (i + 1 + x >= j) (j, x - math.min(x, j - i - 1))
      else (i + x, 0)
    }

    t._1 + t._2
  }

  val t = scala.io.StdIn.readInt()

  val input: List[Rank] = (0 until t)
    .foldLeft(List.empty[Rank]) { case (rs, _) =>
      val Array(_, x) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val as          = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

      Rank(x, as) :: rs
    }
    .reverse

  val output = input.map(possible)

  output.foreach(println)
}
