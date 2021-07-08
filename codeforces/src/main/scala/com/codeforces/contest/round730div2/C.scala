package com.codeforces.contest.round730div2

/** C. Need for Pink Slips
  * https://codeforces.com/contest/1543/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val scale = 1e8

  val t = readInt()

  (0 until t).foreach { _ =>
    // c + m + p == 1, 0 < c, m, p < 1
    // 0.1 <= v <= 0.9
    val Array(c, m, p, v) = readLine().split(" ").map(s => (s.toDouble * scale).toInt)

    def reward(slips: List[Int]): List[Int] =
      slips match {
        case x :: xs if x <= v => xs.map(_ + x / xs.length)
        case x :: xs if x > v  => xs.map(_ + v / xs.length) :+ (x - v)
        case _                 => slips
      }

    def race(slips: List[Int]): Double =
      slips match {
        case x :: y :: Nil      =>
          x / scale + y / scale * (1 + race(reward(y :: x :: Nil)))
        case x :: y :: z :: Nil =>
          x / scale +
            y / scale * (1 + race(reward(y :: x :: z :: Nil))) +
            z / scale * (1 + race(reward(z :: x :: y :: Nil)))
        case _                  => 1
      }

    val ans = race(List(p, m, c))

    println(ans)

  }
}
