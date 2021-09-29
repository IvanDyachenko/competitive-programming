package com.codeforces.contest.round744div3

/** E1. Permutation Minimization by Deque
  * https://codeforces.com/contest/1579/problem/E1
  */
object E1 extends App {

  def permutationMinimizationByDeque(an: List[Int]): List[Int] = {
    require(an.length > 0, "The size of an permutation should be at least 1")

    val (left, right) = an.drop(1).foldLeft((List(an.head), List.empty[Int])) {
      case ((xs @ x :: _, ys), a) if a < x => (a :: xs, ys)
      case ((xs, ys), a)                   => (xs, a :: ys)
    }

    left ++ right.reverse
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n).toList

    val bn = permutationMinimizationByDeque(an)

    out.println(bn.mkString(" "))
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
