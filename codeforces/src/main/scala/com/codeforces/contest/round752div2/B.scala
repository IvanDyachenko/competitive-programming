package com.codeforces.contest.round752div2

/** B. XOR Specia-LIS-t
  * https://codeforces.com/contest/1604/problem/B
  */
object B extends App {

  def xorSpeciaLISt(xs: IndexedSeq[Int]): Boolean =
    xs.length % 2 == 0 || xs.indices.drop(1).exists { i => xs(i) <= xs(i - 1) }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n)

    xorSpeciaLISt(an) match {
      case true  => out.println("YES")
      case false => out.println("NO")
    }
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
