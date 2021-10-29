package com.codeforces.contest.round116edu

/** B. Update Files
  * https://codeforces.com/contest/1606/problem/B
  */
object B extends App {

  def log2(x: Long): Int = {
    @annotation.tailrec
    def go(pow: Int): Int = if (x <= (1L << pow)) pow else go(pow + 1)
    go(0)
  }

  def updateFiles(n: Long, k: Long): Long = (log2(k), log2(n)) match {
    case (log2k, log2n) if log2n <= log2k => log2n
    case (log2k, _)                       =>
      val num4k = (1L << log2k) - 1L
      val rem   = (n - 1L) - num4k

      log2k + (rem + k - 1L) / k
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextLong()
    val k = nextLong()
    val h = updateFiles(n, k)

    out.println(h)
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
