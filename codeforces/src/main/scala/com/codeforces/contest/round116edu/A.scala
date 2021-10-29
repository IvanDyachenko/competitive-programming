package com.codeforces.contest.round116edu

/** A. AB Balance
  * https://codeforces.com/contest/1606/problem/A
  */
object A extends App {

  implicit final class StringOps(private val input: String) extends AnyVal {

    def abBalance: String = {
      require(input.nonEmpty, "The given string should not be empty.")

      input.sliding(2).foldLeft(0) {
        case (count, "ab") => count + 1
        case (count, "ba") => count - 1
        case (count, _)    => count
      } match {
        case 0  => input
        case 1  => s"b${input.tail}"
        case -1 => s"a${input.tail}"
      }
    }
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val s = nextLine()

    out.println(s.abBalance)
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
