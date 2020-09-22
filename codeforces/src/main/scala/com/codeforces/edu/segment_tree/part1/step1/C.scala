package com.codeforces.edu.segment_tree.part1.step1

object C extends App {
  import scala.reflect.ClassTag

  abstract class SegmentTree[A] private (private val z: A)(private val op: (A, A) => A) {
    def update(idx: Int, elem: A): Unit
    def fold(from: Int, until: Int): A
  }

  object SegmentTree {
    def apply[A: ClassTag](as: A*)(z: A)(op: (A, A) => A) = new SegmentTree[A](z)(op) {
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
            val xmiddle  = (xleft + xright) / 2
            val (xl, xr) = (2 * x + 1, 2 * x + 2)

            data(x) = op(go(xl, xleft, xmiddle), go(xr, xmiddle, xright))
          }
          data(x)
        }
        go(0, 0, size)

        data
      }

      override def update(idx: Int, elem: A): Unit = {

        def go(x: Int, xleft: Int, xright: Int): Unit =
          if (idx < xleft || idx >= xright) ()
          else if (xleft + 1 == xright) data(x) = elem
          else {
            val xmiddle  = (xleft + xright) / 2
            val (xl, xr) = (2 * x + 1, 2 * x + 2)

            if (idx < xmiddle) go(xl, xleft, xmiddle)
            else go(xr, xmiddle, xright)

            data(x) = op(data(xl), data(xr))
          }

        go(0, 0, size)
      }

      override def fold(from: Int, until: Int): A = {

        def go(x: Int, xleft: Int, xright: Int): A =
          if (xleft >= until || xright <= from) z
          else if (xleft >= from && xright <= until) data(x)
          else {
            val xmiddle  = (xleft + xright) / 2
            val (xl, xr) = (2 * x + 1, 2 * x + 2)

            op(go(xl, xleft, xmiddle), go(xr, xmiddle, xright))
          }

        go(0, 0, size)
      }
    }
  }

  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt -> 1)

  val tree = SegmentTree[(Int, Int)](an: _*)((1000000000, 1)) {
    case ((a, acount), (b, bcount)) if a == b  => (a, acount + bcount)
    case (left @ (a, acount), (b, _)) if a < b => left
    case (_, right)                            => right
  }

  (0 until m).foreach { _ =>
    readLine().split(" ") match {
      case Array("1", i, v) => tree.update(i.toInt, v.toInt -> 1)
      case Array("2", l, r) =>
        val (x, y) = tree.fold(l.toInt, r.toInt)
        println(s"$x $y")
    }
  }
}
