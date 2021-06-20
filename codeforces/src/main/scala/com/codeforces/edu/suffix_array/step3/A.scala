package com.codeforces.edu.suffix_array.step3

/** A. Substring Search
  * - https://codeforces.com/edu/course/2/lesson/2/3/practice/contest/269118/problem/A
  */
object A extends App {
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
        val blocks = Array.fill(n)(0)
        cs.foreach(c => blocks(c) += 1)

        val positions = blocks.scanLeft(0)(_ + _)

        val sp = Array.ofDim[Int](n)
        ps.foreach { i =>
          val p   = (i - (1 << iter) + n) % n
          val c   = cs(p)
          val pos = positions(c)

          sp(pos) = p
          positions(c) += 1
        }

        val sc = Array.ofDim[Int](n)
        sp.indices.foreach {
          case 0 =>
            sc(sp(0)) = 0
          case i =>
            val (p, q) = (sp(i), sp(i - 1))
            val curr   = cs(p) -> cs((p + (1 << iter)) % n)
            val prev   = cs(q) -> cs((q + (1 << iter)) % n)

            sc(p) = sc(q) + (if (curr == prev) 0 else 1)
        }

        go(iter + 1, sp, sc)
      }

    go(0, ps, cs)
  }

  val str   = readLine()
  val count = readInt()

  val suffs = suffixes(str)

  (0 until count).foreach { _ =>
    val subStr    = readLine()
    val subStrLen = subStr.length

    @annotation.tailrec
    def search(left: Int, right: Int): Boolean =
      if (left + 1 >= right) {
        val shift = suffs(left)

        subStr == str.slice(shift, shift + subStrLen)
      } else {
        val midpoint = (left + right) / 2
        val shift    = suffs(midpoint)
        val prefix   = str.slice(shift, shift + subStrLen)

        subStr.compare(prefix).signum match {
          case 0 | 1 => search(midpoint, right)
          case _     => search(left, midpoint)
        }
      }

    val ans = search(-1, suffs.length) match {
      case true => "Yes"
      case _    => "No"
    }

    println(ans)
  }
}
