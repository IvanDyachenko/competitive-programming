package com.codeforces.contest.round732div2

/** A. AquaMoon and Two Arrays
  * https://codeforces.com/contest/1546/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)
    val bn = readLine().split(" ").map(_.toInt)

    val (pos, neg) = (an zip bn).zipWithIndex.foldLeft((List.empty[Int], List.empty[Int])) {
      case ((pos, neg), ((ai, bi), i)) if ai > bi => (List.fill(ai - bi)(i) ::: pos, neg)
      case ((pos, neg), ((ai, bi), i)) if ai < bi => (pos, List.fill(bi - ai)(i) ::: neg)
      case (state, _)                             => state
    }

    if (pos.length == neg.length) {
      println(pos.length)
      (pos zip neg).foreach { case (pi, ni) => println(s"${pi + 1} ${ni + 1}") }
    } else println("-1")
  }
}
