package com.codeforces.ladder.from0to1300

/** A. Sereja and Bottles
  * - https://codeforces.com/contest/315/problem/A
  */
object ASerejaAndBottles extends App {
  import scala.io.StdIn._

  val n = readInt()

  val (as, bs) = (0 until n).foldLeft((List.empty[Int], List.empty[Int])) { case ((as, bs), _) =>
    val Array(a, b) = readLine().split(" ").map(_.toInt)
    (a :: as, b :: bs)
  }

  val ans = n - (as zip bs).collect {
    case (a, b) if a == b && bs.count(_ == a) > 1 => 1
    case (a, b) if a != b && bs.exists(_ == a)    => 1
  }.sum

  println(ans)
}
