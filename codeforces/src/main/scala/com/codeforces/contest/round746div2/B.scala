package com.codeforces.contest.round746div2

/** B. Hemose Shopping
  * https://codeforces.com/contest/1592/problem/B
  */
object B extends App {

  def hemoseShopping(an: IndexedSeq[Int], x: Int): Boolean = {
    val bn = an.sorted

    ((an.length - x) until x).forall(i => an(i) == bn(i))
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val x  = nextInt()
    val an = nextInts(n)

    hemoseShopping(an, x) match {
      case true  => out.println("YES")
      case false => out.println("NO")
    }
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
