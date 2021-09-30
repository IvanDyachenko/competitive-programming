package com.codeforces.contest.round745div2

/** A. CQXYM Count Permutations
  * https://codeforces.com/contest/1581/problem/A
  *
  * [Proof](https://codeforces.com/blog/entry/95393?#comment-845454):
  *
  *   Let x(i) be the number of permutations having exactly i indices
  *   such that p(j) < p(j+1).
  *
  *   Let y(i) be the number of permutations having exactly i indices
  *   such that p(j) > p(j+1).
  *
  *   First observation:
  *     For any 0<=i<=2n-1 we have x(i) == y(2n-1-i).
  *
  *   Second observation:
  *     For any 0<=i<=2n-1 we have x(i) == y(i).
  *     If we reverse any permutation having i indices lesser than
  *     their next element we will get a permutation having i indices
  *     greater than their next element.
  *
  *   Therefore, we have x(i) == x(2n-1-i) for all i: 0<=i<=2n-1.
  *   Hence \sum_{i=0}^{2n-1} x(i) = 2 * \sum_{i=n}^{2n-1} x(i).
  *   The left part is the total number of permutations which is (2n)!
  *   and our answer is \sum_{i=n}^{2n-1} x(i), so answer is (2n)!/2.
  */
object A extends App {

  lazy val Mod = 1000000007L

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n   = nextInt()
    val ans = (3 to 2 * n).foldLeft(1L)((f, i) => (f * i) % Mod)

    out.println(ans)
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
