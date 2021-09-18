package com.codeforces.contest.round743div2

/** A. Countdown
  * https://codeforces.com/contest/1573/problem/A?locale=en
  */
object A extends App {

  def countdown(digits: Seq[Int]): Int = {
    val reversed = digits.reverse
    reversed.drop(1).foldLeft(reversed.headOption.getOrElse(0)) {
      case (count, 0)     => count
      case (count, digit) => count + digit + 1
    }
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val sn = readLine().split("").map(_.toInt)

    println(countdown(sn))
  }
}
