package com.codeforces.contest.round740div2

/** C. Deep Down Below
  * https://codeforces.com/contest/1561/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val caves      = readInt()
    val (power, _) = Array
      .fill(caves) {
        val Array(k, ak @ _*) = readLine().split(" ").map(_.toInt)

        val power = ak.zipWithIndex.foldLeft(0) { case (p, (ai, i)) => p max (ai - i + 1) }
        (power, k)
      }
      .sorted
      .reduce[(Int, Int)] { case ((ap, ak), (bp, bk)) => (ap max (bp - ak), ak + bk) }

    println(power)
  }

}
