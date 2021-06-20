package com.codeforces.round86edu

/** C. Yet Another Counting Problem
  * - https://codeforces.com/contest/1342/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(a, b, q) = scala.io.StdIn.readLine().split(" ").map(BigInt(_))

    val m   = a.max(b)
    val lcm = a / a.gcd(b) * b

    def prefix(p: BigInt): BigInt = {
      val i = p / lcm
      i * m + p.min(i * lcm + m - 1) - i * lcm + 1
    }

    val ans = (0 until q.toInt).map { _ =>
      val Array(l, r) = scala.io.StdIn.readLine().split(" ").map(BigInt(_))

      val (i, j) = (l / lcm, r / lcm)

      r - l + 1 - prefix(r) + prefix(l - 1)
    }

    println(ans.mkString(" "))
  }
}
