package com.codeforces.round86edu

/**
  * E. Placing Rooks
  * https://codeforces.com/contest/1342/problem/E
  */
object E extends App {
  val MOD = 998244353

  private lazy val factorials: Stream[BigInt] =
    BigInt(0) #:: BigInt(1) #:: factorials.zipWithIndex.tail.map { case (f, i) => (f * i).mod(MOD) }

  private def fact(i: Int): BigInt = factorials(2 + i)

  implicit class BigIntOps(val k: BigInt) extends AnyVal {

    def c(n: Int, mod: Int = MOD): BigInt =
      fact(n) * ???
  }

  val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val ans = ???

  println(ans)

}
