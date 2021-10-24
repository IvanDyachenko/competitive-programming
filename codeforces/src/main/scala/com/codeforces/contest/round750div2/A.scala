package com.codeforces.contest.round750div2

/** A. Luntik and Concerts
  * https://codeforces.com/contest/1582/problem/A
  */
object A extends App {

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val a = nextInt()
    val b = nextInt()
    val c = nextInt()

    val d =
      if (a == b && b == c) 0
      else {
        val f = a + 2 * b + 3 * c
        val h = f / 2
        (f - 2 * h).abs
      }

    out.println(d)
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
