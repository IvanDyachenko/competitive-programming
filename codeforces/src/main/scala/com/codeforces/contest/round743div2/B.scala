package com.codeforces.contest.round743div2

/** B. Swaps
  * https://codeforces.com/contest/1573/problem/B
  */
object B extends App {

  def swaps(an: IndexedSeq[Int], bn: IndexedSeq[Int]): Int = {
    val n    = an.length
    val ab2i = Array.fill(2 * n + 1)(0)
    (0 until n).foreach { i => ab2i(an(i)) = i; ab2i(bn(i)) = i }

    (3 to (2 * n))
      .foldLeft((ab2i(1) + ab2i(2), ab2i(1), ab2i(2))) { case ((count, odd, even), ab) =>
        val i = ab2i(ab)
        (ab % 2) match {
          case 0 => (count min (i + odd), odd, even min i)
          case _ => (count, odd min i, even)
        }
      }
      ._1
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n)
    val bn = nextInts(n)

    out.println(swaps(an, bn))
    out.flush()
  }

  final object InOut {
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
