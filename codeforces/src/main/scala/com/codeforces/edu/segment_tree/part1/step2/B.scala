package com.codeforces.edu.segment_tree.part1.step2

/** B. K-th one
  * - https://codeforces.com/edu/course/2/lesson/4/2/practice/contest/273278/problem/B
  */
object B extends App {
  import scala.reflect.ClassTag

  abstract class SegmentTree[A] private (private val z: A)(private val op: (A, A) => A) {
    def update(idx: Int, f: A => A): Unit
    def indexWhere[B](b: B)(op: (B, A) => (B, Boolean)): Int
  }

  object SegmentTree {
    def apply[A: ClassTag](as: A*)(z: A)(op: (A, A) => A): SegmentTree[A] = new SegmentTree(z)(op) {
      private[this] val size = {
        @annotation.tailrec
        def go(size: Int): Int = if (size < as.length) go(size << 1) else size
        go(1)
      }

      private[this] val data = {
        val data = Array.fill(size << 1)(z)

        def go(x: Int, xleft: Int, xright: Int): A = {
          if (xleft + 1 == xright) {
            if (xleft < as.length) data(x) = as(xleft)
          } else {
            val (l, r)  = (x * 2 + 1, x * 2 + 2)
            val xmiddle = (xleft + xright) / 2

            data(x) = op(go(l, xleft, xmiddle), go(r, xmiddle, xright))
          }
          data(x)
        }
        go(0, 0, size)

        data
      }

      def update(idx: Int, f: A => A): Unit = {

        def go(x: Int, xleft: Int, xright: Int): Unit =
          if (xleft > idx || xright <= idx) ()
          else if (xleft + 1 == xright) data(x) = f(data(x))
          else {
            val (l, r)  = (x * 2 + 1, x * 2 + 2)
            val xmiddle = (xleft + xright) / 2

            if (idx < xmiddle) go(l, xleft, xmiddle)
            else go(r, xmiddle, xright)

            data(x) = op(data(l), data(r))
          }
        go(0, 0, size)
      }

      def indexWhere[B](b: B)(op: (B, A) => (B, Boolean)): Int = {

        def go(b: B, x: Int, xleft: Int, xright: Int): Int =
          if (xleft + 1 == xright) xleft
          else {
            val (l, r)  = (x * 2 + 1, x * 2 + 2)
            val xmiddle = (xleft + xright) / 2

            val (xb, xchild) = op(b, data(l))

            if (xchild) go(xb, l, xleft, xmiddle)
            else go(xb, r, xmiddle, xright)
          }

        go(b, 0, 0, size)
      }
    }
  }

  import InOut._

  val Array(n, m) = nextInts(2)
  val an          = nextInts(n)

  val tree = SegmentTree(an: _*)(0)(_ + _)

  (0 until m).foreach { _ =>
    nextInts(2) match {
      case Array(1, i) => tree.update(i, a => (a - 1).abs)
      case Array(2, k) =>
        val idx = tree.indexWhere(k) {
          case (k, a) if k < a => (k, true)
          case (k, a)          => (k - a, false)
        }

        out.println(idx)
    }
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
