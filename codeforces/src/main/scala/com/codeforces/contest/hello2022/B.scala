package com.codeforces.contest.hello2022

/** B. Integers Shop
  * https://codeforces.com/contest/1621/problem/B
  */
object B extends App {
  val A = (1e9 + 1).toInt

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextInt()

    (0 until n).foldLeft((A, A), (0, A), (0, A)) { case (((l, lc), (r, rc), (s, sc)), _) =>
      val Array(li, ri, ci) = nextInts(3)
      val si                = ri - li + 1

      val (ln, lnc) =
        if (li < l) (li, ci)
        else if (li == l) (li, ci min lc)
        else (l, lc)

      val (rn, rnc) =
        if (ri > r) (ri, ci)
        else if (ri == r) (ri, ci min rc)
        else (r, rc)

      val (sn, snc) =
        if (si > s) (si, ci)
        else if (si == s) (si, ci min sc)
        else (s, sc)

      val cost =
        if (sn == rn - ln + 1) snc.min(lnc + rnc)
        else (lnc + rnc)

      out.println(cost)

      ((ln, lnc), (rn, rnc), (sn, snc))
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
