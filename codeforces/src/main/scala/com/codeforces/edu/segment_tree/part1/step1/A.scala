package com.codeforces.edu.segment_tree.part1.step1

/**
  * A. Segment Tree for the Sum
  * https://codeforces.com/edu/course/2/lesson/4/1/practice/contest/273169/problem/A
  */
object A extends App {
  import scala.reflect.ClassTag

  sealed abstract class SegmentTree[A] private (private val z: A)(private val op: (A, A) => A) {
    def update(idx: Int, elem: A): Unit
    def fold(from: Int, to: Int): A
  }

  object SegmentTree {
    def apply[A: ClassTag](it: Iterable[A])(z: A)(op: (A, A) => A): SegmentTree[A] =
      new SegmentTree[A](z)(op) {
        private[this] val source = it.toArray

        private[this] val size = {
          @annotation.tailrec
          def go(s: Int): Int = if (s >= source.length) s else go(s << 1)
          go(1)
        }

        private[this] val data = {
          val d = Array.fill[A](size << 1)(z)

          def go(x: Int, lx: Int, rx: Int): A = {
            if (lx + 1 == rx) {
              if (lx < source.length) d(x) = source(lx)
            } else {
              val mx = (lx + rx) / 2

              val left  = go(2 * x + 1, lx, mx)
              val right = go(2 * x + 2, mx, rx)

              d(x) = op(left, right)
            }

            d(x)
          }
          go(0, 0, size)

          d
        }

        def update(idx: Int, elem: A): Unit = {
          def go(x: Int, lx: Int, rx: Int): Unit =
            if (lx + 1 == rx) {
              data(x) = elem
            } else {
              val mx = (lx + rx) / 2

              if (idx < mx) go(2 * x + 1, lx, mx)
              else go(2 * x + 2, mx, rx)

              data(x) = op(data(2 * x + 1), data(2 * x + 2))
            }

          go(0, 0, size)
        }

        def fold(from: Int, to: Int): A = {
          def go(x: Int, lx: Int, rx: Int): A =
            if (lx >= to || rx <= from) z
            else if (from <= lx && rx <= to) data(x)
            else {
              val mx = (rx + lx) / 2

              op(go(2 * x + 1, lx, mx), go(2 * x + 2, mx, rx))
            }

          go(0, 0, size)
        }
      }
  }

  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toLong)

  val tree = SegmentTree(an)(0L)(_ + _)

  (0 until m).foreach { _ =>
    readLine().split(" ") match {
      case Array("1", i, v) => tree.update(i.toInt, v.toLong)
      case Array("2", l, r) => println(tree.fold(l.toInt, r.toInt))
    }
  }
}
