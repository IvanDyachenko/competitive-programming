package com.codeforces.contest.deltix2021spring

/** B. Lord of the Values
  * - https://codeforces.com/contest/1523/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine()

    println(n / 2 * 6)

    (1 until (n, 2)).foreach { i =>
      val j = i + 1

      println(s"1 ${i} ${j}")
      println(s"2 ${i} ${j}")
      println(s"1 ${i} ${j}")
      println(s"1 ${i} ${j}")
      println(s"2 ${i} ${j}")
      println(s"1 ${i} ${j}")
    }
  }
}
