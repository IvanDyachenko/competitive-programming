package com.codeforces.contest.hello2022

/** A. Stable Arrangement of Rooks
  * https://codeforces.com/contest/1621/problem/A
  */
object A extends App {

  sealed trait Row {
    def size: Int
  }
  final case class Empty(size: Int)           extends Row {
    override def toString(): String = "." * size
  }
  final case class Rook(size: Int, rook: Int) extends Row {
    override def toString(): String = "." * rook + "R" + "." * (size - rook - 1)
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextInt()
    val k = nextInt()

    val m = 2 * (k - 1) + 1

    if (n >= m)
      (0 until n).foldLeft(k) {
        case (rooks, row) if row % 2 == 0 && rooks > 0 =>
          out.println(Rook(n, row))
          rooks - 1
        case (rooks, _) =>
          out.println(Empty(n))
          rooks
      }
    else
      out.println(-1)
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
