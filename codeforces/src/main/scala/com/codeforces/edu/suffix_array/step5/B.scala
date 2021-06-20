package com.codeforces.edu.suffix_array.step5

/** B. Longest Common Substring
  * - https://codeforces.com/edu/course/2/lesson/2/5/practice/contest/269656/problem/B
  */
object B extends App {

  def lcs(str1: String, str2: String): String = {
    val str = s"$str1-$str2"

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

    def opposite(i: Int, j: Int): Boolean =
      if (i > j) opposite(j, i)
      else i < str1.length && j > str1.length

    @annotation.tailrec
    def go(iter: Int, ps: IndexedSeq[Int], cs: IndexedSeq[Int]): String =
      if (1 << iter > n) {
        val lcp = Array.ofDim[Int](n)

        str.indices.foldLeft(0) { case (k, i) =>
          val pi = cs(i)
          val pj = pi - 1
          val j  = ps(pj)

          @annotation.tailrec
          def go(k: Int): Int = if (s(i + k) == s(j + k)) go(k + 1) else k

          lcp(pi) = go(0 max (k - 1))
          lcp(pi)
        }

        val (from, length) = ps.indices.foldLeft((0, 0)) {
          case (state, 0)                   => state
          case (state @ (from, length), pi) =>
            val pj     = pi - 1
            val (i, j) = (ps(pi), ps(pj))

            if (opposite(i, j) && length < lcp(pi)) (i, lcp(pi))
            else state
        }

        str.slice(from, from + length)
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

            sc(q) = sc(p) + (if (curr == prev) 0 else 1)
        }

        go(iter + 1, sp, sc)
      }

    go(0, ps, cs)
  }

  import scala.io.StdIn._

  val s = readLine()
  val t = readLine()

  val ans = lcs(s, t)

  println(ans)
}
