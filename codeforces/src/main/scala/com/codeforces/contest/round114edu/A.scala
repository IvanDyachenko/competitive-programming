package com.codeforces.contest.round114edu

/** A. Regular Bracket Sequences
  * https://codeforces.com/contest/1574/problem/A
  */
object A extends App {

  def brackets(n: Int): List[String] =
    (0 until n).foldLeft(List.empty[String]) { (brackets, i) =>
      val bracket = "(" * (n - 1) + ")" * i + "(" + ")" * (n - i)
      bracket :: brackets
    }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextInt()

    out.println(brackets(n).mkString("\n"))
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
