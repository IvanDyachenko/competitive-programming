package com.codeforces.contest.round740div2

/** A. Simply Strange Sort
  * https://codeforces.com/contest/1561/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val count = {
      @annotation.tailrec
      def go(i: Int): Int =
        if (an.isSorted) i
        else {
          ((i % 2) until (n - 1, 2)).foreach {
            case i if an(i) > an(i + 1) => an.swap(i, i + 1)
            case _                      =>
          }
          go(i + 1)
        }
      go(0)
    }

    println(count)
  }

  implicit final class ArrayOps[T](private val xs: Array[T]) extends AnyVal {
    def swap(i: Int, j: Int): Unit = {
      val xi = xs(i)
      xs(i) = xs(j)
      xs(j) = xi
    }

    def isSorted(implicit ord: Ordering[T]): Boolean =
      (0 until (xs.length - 1)).forall(i => ord.lteq(xs(i), xs(i + 1)))
  }

}
