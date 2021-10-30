package com.codeforces.contest.round752div2

/** C. Di-visible Confusion
  * https://codeforces.com/contest/1604/problem/C
  */
object C extends App {

  def divisibleConfusion(an: IndexedSeq[Int]): Boolean = {
    val n = an.length

    @annotation.tailrec
    def go(index: Int): Boolean =
      if (index == n) true
      else {
        val ai = an(index)
        index.to(0, -1).exists { j => ai % (j + 2) != 0 } && go(index + 1)
      }

    go(0)
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n)

    divisibleConfusion(an) match {
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
