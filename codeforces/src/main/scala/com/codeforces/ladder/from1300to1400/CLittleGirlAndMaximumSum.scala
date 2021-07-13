package com.codeforces.ladder.from1300to1400

/** C. Little Girl and Maximum Sum
  * https://codeforces.com/problemset/problem/276/C
  */
object CLittleGirlAndMaximumSum extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt).sorted(Ordering[Int].reverse)

  val ans = {
    val counts = {
      val bit = new BIT(n)
      (0 until m).foreach { _ =>
        val Array(l, r) = readLine().split(" ").map(_.toInt)
        bit.update(l, 1)
        bit.update(r + 1, -1)
      }

      (0 until n).map(i => bit.query(i + 1)).sorted(Ordering[Long].reverse)
    }

    (0 until n).foldLeft(0L) { case (sum, i) => sum + counts(i) * an(i) }
  }

  println(ans)

  // Fenwick tree
  class BIT(private val n: Int) {
    private val bits = Array.fill {
      val msb = Integer.highestOneBit(n + 1)
      if (msb <= n) msb << 1 else msb
    }(0)

    @annotation.tailrec
    final def update(i: Int, delta: Int): Unit =
      if (i > n) ()
      else {
        bits(i) += delta
        update(i + Integer.lowestOneBit(i), delta)
      }

    final def query(to: Int): Long = {
      @annotation.tailrec
      def go(i: Int, result: Long): Long =
        if (i == 0) result
        else go(i - Integer.lowestOneBit(i), result + bits(i))
      go(to, 0L)
    }

    final def query(from: Int, to: Int): Long = query(to) - query(from - 1)
  }
}
