package com.codeforces.contest.round669div2

/** A. Ahahahahahahahaha
  * - https://codeforces.com/contest/1407/problem/0
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val m  = n / 2
    val an = readLine()

    val zeros = an.count(_ == '0')

    if (zeros >= m) {
      println(m)
      println("0 " * m)
    } else {
      // format: off
      println(m + m % 2)
      println("1 " * (m + m % 2))
    }
  }
}
