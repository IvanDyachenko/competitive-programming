package com.codeforces.edu.segment_tree.part1.step2

/** A. Segment with the Maximum Sum
  * - https://codeforces.com/edu/course/2/lesson/4/2/practice/contest/273278/problem/A
  */
object A extends App {
  import scala.reflect.ClassTag

  abstract class SegmentTree[A] private (private val z: A)(private val op: (A, A) => A) {
    def update(idx: Int, elem: A): Unit
    def fold(from: Int, until: Int): A
  }

  object SegmentTree {
    def apply[A: ClassTag](as: A*)(z: A)(op: (A, A) => A) = new SegmentTree(z)(op) {
      private[this] val size = {
        @annotation.tailrec
        def go(size: Int): Int = if (size >= as.length) size else go(size << 1)
        go(1)
      }

      private[this] val data = {
        val data = Array.fill(size << 1)(z)

        def go(x: Int, xleft: Int, xright: Int): A = {
          if (xleft + 1 == xright) {
            if (xleft < as.length) data(x) = as(xleft)
          } else {
            val (l, r)  = (2 * x + 1, 2 * x + 2)
            val xmiddle = (xleft + xright) / 2

            data(x) = op(go(l, xleft, xmiddle), go(r, xmiddle, xright))
          }
          data(x)
        }
        go(0, 0, size)

        data
      }

      override def toString: String = data.mkString(" ")

      override def update(idx: Int, elem: A): Unit = {

        def go(x: Int, xleft: Int, xright: Int): Unit =
          if (xleft > idx || xright <= idx) ()
          else if (xleft + 1 == xright) data(x) = elem
          else {
            val (l, r)  = (2 * x + 1, 2 * x + 2)
            val xmiddle = (xleft + xright) / 2

            if (idx < xmiddle) go(l, xleft, xmiddle)
            else go(r, xmiddle, xright)

            data(x) = op(data(l), data(r))
          }
        go(0, 0, size)
      }

      override def fold(from: Int, until: Int): A = {

        def go(x: Int, xleft: Int, xright: Int): A =
          if (xleft >= until || xright <= from) z
          else if (xleft >= from && xright <= until) data(x)
          else {
            val (l, r)  = (2 * x + 1, 2 * x + 2)
            val xmiddle = (xleft + xright) / 2

            op(go(l, xleft, xmiddle), go(r, xmiddle, xright))
          }
        go(0, 0, size)
      }
    }
  }

  import InOut._

  val Array(n, m) = nextInts(2)
  val an          = nextLongs(n)

  def f(a: Long) = if (a < 0) (0L, a, 0L, 0L) else (a, a, a, a)

  val bn = an.map(f)

  val tree = SegmentTree(bn: _*)((0L, 0L, 0L, 0L)) { case ((aseg, asum, apref, asuf), (bseg, bsum, bpref, bsuf)) =>
    (aseg max bseg max (asuf + bpref), asum + bsum, apref max (asum + bpref), bsuf max (bsum + asuf))
  }

  val ans = tree.fold(0, n)._1
  out.println(ans)

  (0 until m).foreach { _ =>
    val Array(i, v) = nextInts(2)

    tree.update(i, f(v))

    val ans = tree.fold(0, n)._1
    out.println(ans)
  }

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
