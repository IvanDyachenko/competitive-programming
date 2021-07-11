package com.codeforces.contest.round732div2

/** B. AquaMoon and Stolen String
  * https://codeforces.com/contest/1546/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  def f: Array[String] => Array[Int] = _.map(_.toArray).transpose.map(_.foldLeft(0)(_ + _))

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, _) = readLine().split(" ").map(_.toInt)
    val os          = Array.fill(n)(readLine())
    val fs          = Array.fill(n - 1)(readLine())

    val ans = (f(os) zip f(fs)).map { case (o, f) => (o - f).toChar }.mkString("")

    println(ans)
  }
}
