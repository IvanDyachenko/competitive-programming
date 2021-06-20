package com.codeforces.edu.suffix_array.step3

/** B. Counting Substrings
  * - https://codeforces.com/edu/course/2/lesson/2/3/practice/contest/269118/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  def suffixes(str: String): IndexedSeq[Int] = {
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
    def go(iter: Int, ps: IndexedSeq[Int], cs: IndexedSeq[Int]): IndexedSeq[Int] =
      if ((1 << iter) > n) ps
      else {
        val sp = Array.ofDim[Int](n)
        val sc = Array.ofDim[Int](n)

        val blocks = Array.fill(n)(0)
        cs.foreach(c => blocks(c) += 1)

        val positions = blocks.scanLeft(0)(_ + _)

        ps.foreach { p =>
          val i   = (p - (1 << iter) + n) % n
          val c   = cs(i)
          val pos = positions(c)

          sp(pos) = i
          positions(c) += 1
        }

        sp.indices.foreach {
          case 0 =>
            sc(sp(0)) = 0
          case i =>
            val (p, q) = (sp(i), sp(i - 1))
            val curr   = cs(p) -> cs((p + (1 << iter)) % n)
            val prev   = cs(q) -> cs((q + (1 << iter)) % n)

            sc(p) = sc(q) + (if (prev == curr) 0 else 1)
        }

        go(iter + 1, sp, sc)
      }

    go(0, ps, cs)
  }

  val str     = readLine()
  val queries = readInt()

  val suffs = suffixes(str)

  def times(sub: String): Int = {
    val (n, m) = (suffs.length, sub.length)

    @annotation.tailrec
    def binarySearch(left: Int, right: Int)(f: Int => Boolean): (Int, Int) =
      if (left + 1 >= right) (left, right)
      else {
        val midpoint = (left + right) / 2

        f(midpoint) match {
          case true => binarySearch(midpoint, right)(f)
          case _    => binarySearch(left, midpoint)(f)
        }
      }

    val left = binarySearch(-1, n) { midpoint =>
      val shift = suffs(midpoint)
      val bus   = str.slice(shift, shift + m)

      sub >= bus
    }

    val right = binarySearch(-1, n) { midpoint =>
      val shift = suffs(midpoint)
      val bus   = str.slice(shift, shift + m)

      sub > bus
    }

    if (right._2 > left._1) 0
    else left._1 - right._2 + 1
  }

  (0 until queries).foreach { _ =>
    val query = readLine()
    println(times(query))
  }
}
