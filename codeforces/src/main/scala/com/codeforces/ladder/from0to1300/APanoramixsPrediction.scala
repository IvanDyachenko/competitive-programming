package com.codeforces.ladder.from0to1300

/** A. Panoramix's Predictio
  * - https://codeforces.com/problemset/problem/80/A
  */
object APanoramixsPrediction extends App {
  import scala.io.StdIn._

  lazy val primes: Stream[Int] =
    2 #:: Stream.iterate(3)(_ + 2).filter(isPrime)

  def isPrime(number: Int): Boolean = primes.takeWhile(prime => prime * prime <= number).forall(number % _ != 0)

  val Array(n, m) = readLine().split(" ").map(_.toInt)

  val ans = isPrime(m) && primes.indexOf(n) + 1 == primes.indexOf(m) match {
    case true => "YES"
    case _    => "NO"
  }

  println(ans)
}
