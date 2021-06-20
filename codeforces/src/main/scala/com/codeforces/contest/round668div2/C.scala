package com.codeforces.contest.round668div2

/** C. Balanced Bitstring
  * - https://codeforces.com/contest/1405/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val sn          = readLine()

    def isBalanced: Boolean = {
      var mk = Array.fill(k)('?')

      @annotation.tailrec
      def go(i: Int): Boolean =
        if (i == n) true
        else if (sn(i) == '?') go(i + 1)
        else if (mk(i % k) == '?') {
          mk(i % k) = sn(i)
          go(i + 1)
        } else mk(i % k) == sn(i) && go(i + 1)

      go(0) && mk.count(_ == '1') <= k / 2 && mk.count(_ == '0') <= k / 2
    }

    val ans = isBalanced match {
      case true => "YES"
      case _    => "NO"
    }

    println(ans)
  }
}
