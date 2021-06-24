package com.codeforces.ladder.from1300to1400

/** B. Lucky Numbers (easy)
  * https://codeforces.com/problemset/problem/96/B
  */
object BLuckyNumbersEasy extends App {
  import scala.io.StdIn._

  // 1 <= n <= 10^9
  // Пусть n = d1 d2 d3 d4 ... dl
  //   1. Если l%2 == 1, то ответом будет число вида 444...777,
  //   причем длина такого ответа равна l+1.
  //   2. Если l%2 == 0, то длина ответа составляет l или l+2.
  // А значит максимальная длина ответа составляет 10, так как n<=10^9.

  private def lucky(n: Long): Long = {
    val l = n.toString.length

    if (l % 2 == 1) {
      val h = (l + 1) / 2
      ("4" * h + "7" * h).toLong
    } else {
      def go(m: Int): Option[Long] =
        if (m > l + 2) None
        else {
          val h = m / 2

          ("4" * h + "7" * h).permutations
            .map(_.toLong)
            .collectFirst { case t if t >= n => t }
            .orElse(go(m + 2))
        }

      go(l).get
    }
  }

  val n   = readInt()
  val ans = lucky(n)

  println(ans)
}
