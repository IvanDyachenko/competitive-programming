package com.codeforces.round86edu

/** E. Placing Rooks
  * - https://codeforces.com/contest/1342/problem/E
  */
object E extends App {
  val MOD = 998244353

  private lazy val factorials: Stream[Long] =
    0L #:: 1L #:: factorials.zipWithIndex.tail.map { case (f, i) => (f * i) % MOD }

  private def factorial(i: Int): Long       =
    factorials(i + 1)

  implicit class LongOps(val l: Long) extends AnyVal {

    def binpow(exp: Int): Long = {
      def go(x: Long, exp: Int, res: Long = 1L): Long =
        if (exp == 0) res
        else if (exp % 2 == 1) go(x, exp - 1, (res * x) % MOD)
        else go((x * x) % MOD, exp >> 1, res)

      go(l % MOD, exp)
    }

    def mmi: Long = l binpow (MOD - 2)

    def C(n: Int): Long =
      (factorial(n) * (factorial(l.toInt) * factorial(n - l.toInt)).mmi) % MOD
  }

  val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val ans =
    if (k > n - 1) 0
    else {
      val c = n - k

      val fixed = (0 to c).foldLeft(0L) { (sum, i) =>
        val next = (i.C(c) * (c - i).binpow(n)) % MOD

        if (i                   % 2 == 0) (sum + next) % MOD
        else (sum + MOD - next) % MOD
      }

      val all = c.C(n) * fixed

      if (k == 0) all % MOD
      else (all * 2)  % MOD
    }

  println(ans)
}
