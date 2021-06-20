package com.codeforces.round93edu

/** B. Substring Removal Game
  * - https://codeforces.com/contest/1398/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()

    val ans = s
      .foldLeft(List(0)) {
        case (0 :: xs, '0') => 0 :: xs
        case (xs, '0')      => 0 :: xs
        case (x :: xs, '1') => (x + 1) :: xs
      }
      .sorted(Ordering.Int.reverse)
      .zipWithIndex
      .collect { case (l, i) if i % 2 == 0 => l }
      .reduceOption(_ + _)
      .getOrElse(0)

    println(ans)
  }
}
