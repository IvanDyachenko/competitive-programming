package com.codeforces.contest.round729div2

/** B. Plus and Multiply
  * https://codeforces.com/contest/1542/problem/B
  *
  * n = (((1 * a^i + j * b) * a^k + t * b) * a^e + r * b) * ...
  * n = ((a^{i+k} + b * (j * a^k + t)) * a^e + r * b) * ...
  * n = (a^{i+l+e} + b * (j * a^{k+e} + t * a^e + e)) * ...
  * ...
  * n = a^p + b*q
  *
  * Only the operatyion a * x might change the result of (x mod b),
  * so a^p===n(mod b) which implies that (n - a^p) mod b == 0.
  */
object B extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, a, b) = readLine().split(" ").map(_.toLong)

    val ans = {
      @annotation.tailrec
      def go(x: Long): Boolean = x <= n && ((n - x) % b == 0 || a != 1 && go(x * a))

      go(1)
    }

    ans match {
      case true => println("Yes")
      case _    => println("No")
    }
  }
}
