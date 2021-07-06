package com.codeforces.ladder.from1300to1400

/** B. Prime Matrix
  * https://codeforces.com/problemset/problem/271/B
  */
object BPrimeMatrix extends App {
  import InOut._

  def binarySearch(from: Int, to: Int, f: Int => Boolean): Int = {
    @annotation.tailrec
    def go(l: Int, r: Int): Int =
      if (l + 1 >= r) r
      else {
        val m = (l + r) / 2
        f(m) match {
          case true => go(l, m)
          case _    => go(m, r)
        }
      }

    go(from, to)
  }

  val primes = {
    lazy val primes       = 2 #:: Stream.iterate(3)(_ + 2).filter(p)
    def p: Int => Boolean = number => primes.takeWhile(prime => prime * prime <= number).forall(number % _ != 0)
    primes.take(10000).toArray
  }

  val Array(n, m) = nextInts(2)
  val matrix      = Array.fill(n) {
    nextInts(m).map { x => primes(binarySearch(-1, 10000, primes(_) >= x)) - x }
  }

  val ans = {
    val temp = (0 until n).foldLeft(Int.MaxValue) { case (count, i) => count min matrix(i).sum }
    (0 until m).foldLeft(temp) { case (count, j) =>
      count min (0 until n).foldLeft(0) { case (c, i) => c + matrix(i)(j) }
    }
  }

  out.println(ans)
  out.flush()

  final object InOut {
    import java.util.Scanner

    val in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out = new java.io.PrintWriter(System.out, false)

    def nextInt()        = Integer.parseInt(nextToken())
    def nextInts(n: Int) = Array.fill(n)(nextInt())

    def nextLong()        = java.lang.Long.parseLong(nextToken())
    def nextLongs(n: Int) = Array.fill(n)(nextLong())

    def nextBig()        = BigInt(nextToken())
    def nextBigs(n: Int) = Array.fill(n)(nextBig())

    def nextLine() = in.readLine()

    private[this] var tokenizer: java.util.StringTokenizer = _

    def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }
}
