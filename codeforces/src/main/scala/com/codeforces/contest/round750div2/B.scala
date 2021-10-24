package com.codeforces.contest.round750div2

/** B. Luntik and Subsequences
  * https://codeforces.com/contest/1582/problem/B
  */
object B extends App {

  def numberOfNearlyFull(an: IndexedSeq[Int]): Long = an.foldLeft(0L)(_ + _) match {
    case 0L => 0L
    case 1L => 1L << (an.length - 1)
    case _  =>
      val ones  = an.count(_ == 1)
      val zeros = an.count(_ == 0)

      (1L << zeros) * ones
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n)

    out.println(numberOfNearlyFull(an))
  }

  out.flush()

  object InOut {
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

    private[this] def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}
