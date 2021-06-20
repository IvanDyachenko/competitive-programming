package com.codeforces.round88edu

/** C. Mixing Water
  * - https://codeforces.com/contest/1359/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(h, c, t) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val d = c + h - 2 * t

    val ans =
      if (d >= 0) 2
      else if (h <= t) 1
      else if (c >= t) 2
      else { // c < t < h
        val k  = (t - h) / d.toDouble
        val ks = List(k.floor, k.ceil).sortBy(k => math.abs((h - t + k * d) / (1.0 + 2 * k)))

        (1 + 2 * ks.head).toInt
      }

    println(ans)
  }
}
