package com.codeforces.round85edu

/** B. Middle Class
  * - https://codeforces.com/contest/1334/problem/B
  */
object B extends App {
  case class Savings(x: Int, as: List[Int])

  val t = scala.io.StdIn.readInt()

  private def wealthy(s: Savings): Int = {
    val Savings(x, as) = s

    val (ps, rs) = as.sorted.span(_ < x)
    val rl       = rs.length

    val overage: Long = rs.foldLeft(0L)(_ + _ - x)

    val (_, pl) = ps.reverse
      .foldLeft((overage, 0)) { case ((overage, count), a) =>
        if (overage < x - a) (overage, count)
        else (overage - x + a, count + 1)
      }

    rl + pl
  }

  val input = (0 until t)
    .foldLeft(List.empty[Savings]) { (acc, _) =>
      val Array(n, x) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val as          = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

      Savings(x, as) :: acc
    }
    .reverse

  val output = input.map(wealthy)

  println(output.mkString("\n"))
}
