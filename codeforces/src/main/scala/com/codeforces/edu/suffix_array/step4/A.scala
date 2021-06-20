package com.codeforces.edu.suffix_array.step4

/** A. Suffix Array and LCP
  * - https://codeforces.com/edu/course/2/lesson/2/4/practice/contest/269119/problem/A
  */
object A extends App {

  def lcp(str: String): (IndexedSeq[Int], IndexedSeq[Int]) = {
    val s = str + "$"
    val n = s.length

    val ps = Array.ofDim[Int](n)
    val cs = Array.ofDim[Int](n)

    s.zipWithIndex.sortBy(_._1).zipWithIndex.foldLeft('$') {
      case (_, ((curr, p), 0))    =>
        ps(0) = p
        cs(p) = 0
        curr
      case (prev, ((curr, p), i)) =>
        ps(i) = p
        cs(p) = cs(ps(i - 1)) + (if (curr == prev) 0 else 1)
        curr
    }

    @annotation.tailrec
    def go(iter: Int, ps: IndexedSeq[Int], cs: IndexedSeq[Int]): (IndexedSeq[Int], IndexedSeq[Int]) =
      if (1 << iter > n) {
        val lcp = Array.ofDim[Int](n - 1)

        str.indices.foldLeft(0) { case (k, i) =>
          val pi = cs(i)
          val pj = pi - 1
          val j  = ps(pj)

          @annotation.tailrec
          def go(k: Int): Int = if (s(i + k) == s(j + k)) go(k + 1) else k

          lcp(pi - 1) = go(0 max (k - 1))
          lcp(pi - 1)
        }

        (ps, lcp)
      } else {
        val sp = Array.ofDim[Int](n)
        val sc = Array.ofDim[Int](n)

        val blocks = Array.fill(n)(0)
        cs.foreach(c => blocks(c) += 1)

        val positions = blocks.scanLeft(0)(_ + _)

        ps.foreach { p =>
          val q = (p - (1 << iter) + n) % n
          val c = cs(q)
          val i = positions(c)

          sp(i) = q
          positions(c) += 1
        }

        cs.indices.foreach {
          case 0 =>
            sc(sp(0)) = 0
          case i =>
            val (p, q) = (sp(i - 1), sp(i))
            val prev   = cs(p) -> cs((p + (1 << iter)) % n)
            val curr   = cs(q) -> cs((q + (1 << iter)) % n)

            sc(q) = sc(p) + (if (prev == curr) 0 else 1)
        }

        go(iter + 1, sp, sc)
      }

    go(0, ps, cs)
  }

  import InOut._

  val s = nextLine()

  val (ans1, ans2) = lcp(s)

  out.println(ans1.mkString(" "))
  out.println(ans2.mkString(" "))
  out.flush()

  final object InOut {
    import java.util.Scanner

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
