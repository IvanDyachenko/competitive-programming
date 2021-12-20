package com.codeforces.contest.round762div3

/** A. Square String?
  * https://codeforces.com/contest/1619/problem/A
  */
object A extends App {

  implicit final class StringOps(private val s: String) extends AnyVal {
    def isSquare: Boolean = {
      val (half, remainder) = (s.size / 2, s.size % 2)
      remainder == 0 && (0 until half).forall(i => s(i) == s(i + half))
    }
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val s = nextLine()

    s.isSquare match {
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
