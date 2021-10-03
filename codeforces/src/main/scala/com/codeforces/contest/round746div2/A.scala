package com.codeforces.contest.round746div2

/** A. Gamer Hemose
  * https://codeforces.com/contest/1592/problem/A
  */
object A extends App {

  def gamerHemose(an: Array[Int], h: Int): Int = {
    val Array(a1, a2, _*) = an.sorted(Ordering[Int].reverse)

    (h / (a1 + a2), h % (a1 + a2)) match {
      case (i, 0)            => 2 * i
      case (i, j) if j <= a1 => 2 * i + 1
      case (i, _)            => 2 * i + 2
    }
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val h  = nextInt()
    val an = nextInts(n)

    out.println(gamerHemose(an, h))
  }

  out.flush()

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
