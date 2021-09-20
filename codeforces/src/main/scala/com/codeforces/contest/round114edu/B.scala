package com.codeforces.contest.round114edu

/** B. Combinatorics Homework
  * https://codeforces.com/contest/1574/problem/B
  */
object B extends App {

  /** Assumption: a >= b >= c
    *
    * - Upper bound: (a - 1) + (b - 1) + (c - 1)
    *   Example: "aaaaabbbc"
    *
    * - Lower bound: a - b - c - 1
    *   Example: "abacabacababaaa"
    */
  def check(a: Int, b: Int, c: Int, m: Int): Boolean =
    m >= 2 * (a max b max c) - a - b - c - 1 && m <= a + b + c - 3

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val Array(a, b, c, m) = nextInts(4)

    check(a, b, c, m) match {
      case true  =>
        out.println("YES")
        out.flush()
      case false =>
        out.println("NO")
        out.flush()
    }
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
