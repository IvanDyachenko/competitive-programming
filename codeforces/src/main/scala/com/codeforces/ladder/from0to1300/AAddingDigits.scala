package com.codeforces.ladder.from0to1300

/** A. Adding Digits
  * - https://codeforces.com/contest/260/problem/A
  */
object AAddingDigits extends App {
  import scala.io.StdIn._

  val Array(a, b, n) = readLine().split(" ").map(_.toInt)
  val d              = (b - (a * 10) % b) % b

  if (d > 9)
    println("-1")
  else
    println(s"$a$d${"0" * (n - 1)}")
}
