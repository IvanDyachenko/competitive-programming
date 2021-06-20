package com.codeforces.edu.segment_tree.part1.step1

/** B. Segment Tree for the Minimum
  * - https://codeforces.com/edu/course/2/lesson/4/1/practice/contest/273169/problem/B
  */
object B extends App {
  import scala.reflect.ClassTag

  abstract class SegmentTree[A: ClassTag] private (private val z: A)(private val op: (A, A) => A) {
    def update(idx: Int, value: A): Unit
    def fold(from: Int, until: Int): A
  }

  object SegmentTree {
    def apply[A: ClassTag](as: A*)(z: A)(op: (A, A) => A): SegmentTree[A] = new SegmentTree[A](z)(op) {
      private[this] val size = {
        @annotation.tailrec
        def go(size: Int): Int = if (size >= as.length) size else go(size << 1)
        go(1)
      }

      private[this] val data = {
        val data = Array.fill[A](size << 1)(z)

        def go(pos: Int, from: Int, until: Int): A = {
          if (from + 1 == until) {
            if (from < as.length) data(pos) = as(from)
          } else {
            val mid           = (from + until) / 2
            val (left, right) = (2 * pos + 1, 2 * pos + 2)

            data(pos) = op(go(left, from, mid), go(right, mid, until))
          }

          data(pos)
        }
        go(0, 0, size)

        data
      }

      override def update(idx: Int, value: A): Unit = {
        def go(pos: Int, from: Int, until: Int): A = {
          if (idx < from || idx >= until) z
          else if (from + 1 == until) data(pos) = value
          else {
            val mid           = (from + until) / 2
            val (left, right) = (2 * pos + 1, 2 * pos + 2)

            if (idx < mid) go(left, from, mid)
            else go(right, mid, until)

            data(pos) = op(data(left), data(right))
          }

          data(pos)
        }

        go(0, 0, size)
      }

      override def fold(from: Int, until: Int): A = {
        def go(pos: Int, posFrom: Int, posUntil: Int): A =
          if (posFrom >= until || posUntil <= from) z
          else if (posFrom >= from && posUntil <= until) data(pos)
          else {
            val posMid = (posFrom + posUntil) / 2

            op(go(2 * pos + 1, posFrom, posMid), go(2 * pos + 2, posMid, posUntil))
          }

        go(0, 0, size)
      }
    }
  }

  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt)

  val tree = SegmentTree(an: _*)(100000)(_ min _)

  (0 until m).foreach { _ =>
    readLine().split(" ") match {
      case Array("1", i, v) => tree.update(i.toInt, v.toInt)
      case Array("2", l, r) => println(tree.fold(l.toInt, r.toInt))
    }
  }
}
