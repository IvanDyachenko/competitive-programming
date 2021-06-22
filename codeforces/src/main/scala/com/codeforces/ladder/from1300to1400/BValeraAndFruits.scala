package com.codeforces.ladder.from1300to1400

/** B. Valera and Fruits
  * https://codeforces.com/problemset/problem/441/B
  */
object BValeraAndFruits extends App {
  import scala.io.StdIn._

  val Array(n, v) = readLine().split(" ").map(_.toInt)
  val harvest = {
    val result = Array.fill(3000)(0)

    val days = (0 until n).foldLeft(0) { case (ar, _) =>
      val Array(ai, bi) = readLine().split(" ").map(_.toInt)
      result(ai - 1) += bi
      ar max ai
    }

    result.take(days)
  }

  val ans = {
    val (fruits, remains) = harvest.foldLeft((0, 0)) { case ((fruits, remains), bi) =>
      (fruits + v.min(bi + remains), 0.max(bi - 0.max(v - remains)))
    }
    fruits + v.min(remains)
  }

  println(ans)
}
