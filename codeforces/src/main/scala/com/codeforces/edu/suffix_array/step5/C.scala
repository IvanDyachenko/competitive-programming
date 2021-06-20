package com.codeforces.edu.suffix_array.step5

/** C. Sorting Substrings
  * - https://codeforces.com/edu/course/2/lesson/2/5/practice/contest/269656/problem/C
  */
object C extends App {
  import scala.reflect.ClassTag

  abstract class SparseTable[A] private (private val op: (A, A) => A) {
    def fold(from: Int, to: Int): A
  }

  object SparseTable {
    def apply[A: ClassTag](as: A*)(zero: A)(op: (A, A) => A) = new SparseTable[A](op) {
      private[this] val n = as.length

      private[this] val pl = (1 to n).view
        .scanLeft((0, 1)) { case ((k, pk), l) => if (pk << 1 <= l) (k + 1, pk << 1) else (k, pk) }
        .map(_._1)
        .toArray

      private[this] val st = {
        val st = Array.fill[A](n, pl(n) + 1)(zero)

        as.indices.foreach(i => st(i)(0) = as(i))
        for {
          k <- 1 to pl(n)
          i <- 0 to (n - (1 << k))
        } st(i)(k) = op(st(i)(k - 1), st(i + (1 << (k - 1)))(k - 1))

        st
      }

      override def fold(from: Int, to: Int): A = {
        val k = pl(to - from + 1)
        op(st(from)(k), st(to - (1 << k) + 1)(k))
      }

      override def toString(): String = st.map(_.mkString("\t")).mkString("\n")
    }
  }

  def sort(s: String, lrs: IndexedSeq[(Int, Int)]): IndexedSeq[(Int, Int)] = {
    val str = s + " "
    val n   = str.length

    val ps = Array.ofDim[Int](n)
    val cs = Array.ofDim[Int](n)

    str.zipWithIndex.sortBy(_._1).zipWithIndex.foldLeft(' ') {
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
    def go(iter: Int, ps: IndexedSeq[Int], cs: IndexedSeq[Int]): IndexedSeq[(Int, Int)] =
      if (1 << iter > n) {
        val lcp = Array.ofDim[Int](n)

        s.indices.foldLeft(0) { case (k, i) =>
          val pi = cs(i)
          val pj = pi - 1
          val j  = ps(pj)

          @annotation.tailrec
          def go(k: Int): Int = if (str(i + k) == str(j + k)) go(k + 1) else k

          lcp(pi) = go(0 max (k - 1))
          lcp(pi)
        }

        val st = SparseTable(lcp: _*)(Int.MaxValue)(_ min _)

        def binarySearch(j: Int, size: Int): Int = {

          @annotation.tailrec
          def go(l: Int, r: Int): Int =
            if (l + 1 >= r) r
            else {
              val m = (l + r) / 2

              st.fold(m + 1, r) >= size match {
                case true => go(l, m)
                case _    => go(m, r)
              }
            }

          go(-1, j)
        }

        lrs.map { case (l, r) => (binarySearch(cs(l), r - l + 1), r - l + 1, l, r) }.sorted.map { case (_, _, l, r) =>
          (l, r)
        }
      } else {
        val sp = Array.ofDim[Int](n)
        val sc = Array.ofDim[Int](n)

        val blocks = Array.fill(n)(0)
        cs.foreach(blocks(_) += 1)

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

  import InOut._

  val s   = nextLine()
  val n   = nextInt()
  val lrs = Array.fill(n) {
    val Array(l, r) = nextInts(2)
    (l - 1, r - 1)
  }

  val ans = sort(s, lrs)

  ans.foreach { case (l, r) => out.println(s"${l + 1} ${r + 1}") }
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
