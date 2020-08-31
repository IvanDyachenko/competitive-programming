package com.codeforces.edu.suffix_array

import scala.collection.mutable

object SuffixArray {

  /**
    * A. Suffix Array - 2
    * https://codeforces.com/edu/course/2/lesson/2/2/practice/contest/269103/problem/A
    * https://codeforces.com/edu/course/2/lesson/2/2/practice/contest/269103/submission/91524841
    */
  def suffixes2(str: String): Seq[String] = {
    val s = str + "$"
    val n = s.length

    var ps = Array.ofDim[Int](n)
    var cs = Array.ofDim[Int](n)

    s.zipWithIndex.sortBy(_._1).zipWithIndex.foldLeft('$') {
      case (_, ((curr, p), 0)) =>
        ps(0) = p
        cs(p) = 0
        curr
      case (prev, ((curr, p), i)) =>
        ps(i) = p
        cs(p) = cs(ps(i - 1)) + (if (curr == prev) 0 else 1)
        curr
    }

    /**
      * Count sort
      */
    def sort(ps: IndexedSeq[Int]): IndexedSeq[Int] = {
      var is = cs
        .foldLeft(Array.fill[Int](cs.max + 1)(0)) {
          case (is, c) =>
            is(c) += 1
            is
        }
        .scanLeft(0)(_ + _)

      var sp = Array.ofDim[Int](n)
      ps.foreach { p =>
        val c = cs(p)
        sp(is(c)) = p
        is(c) += 1
      }

      sp
    }

    @annotation.tailrec
    def go(iter: Int): Seq[String] =
      if ((1 << iter) > n) ps.map(p => str.slice(p, n))
      else {
        ps.indices.foreach(i => ps(i) = (ps(i) - (1 << iter) + n) % n)

        ps = sort(ps).toArray

        var sc = Array.ofDim[Int](n)
        ps.indices.foreach {
          case 0 => cs(ps(0)) = 0
          case i =>
            // format: off
            val prev = cs(ps(i - 1)) -> cs((ps(i - 1) + (1 << iter)) % n)
            val curr = cs(ps(i))     -> cs((ps(i)     + (1 << iter)) % n)
            // format: on

            sc(ps(i)) = sc(ps(i - 1)) + (if (curr == prev) 0 else 1)
        }

        cs = sc

        go(iter + 1)
      }

    go(0)
  }

  /**
    * A. Suffix Array - 1
    * https://codeforces.com/edu/course/2/lesson/2/1/practice/contest/269100/problem/A
    * https://codeforces.com/edu/course/2/lesson/2/1/practice/contest/269100/submission/91002753
    */
  def suffixes1(str: String): Seq[String] = {
    val s = str + "$"
    val n = s.length

    @annotation.tailrec
    def go(iter: Int, ps: IndexedSeq[Int] = null, cs: IndexedSeq[Int] = null): Seq[String] = iter match {
      case k if k == -1 =>
        val xs = s.zipWithIndex.sortBy(_._1)
        val (ips, ics, _) = xs.zipWithIndex.foldLeft((Array.ofDim[Int](n), Array.ofDim[Int](n), '$')) {
          case ((ps, cs, _), ((curr, p), 0)) =>
            ps(0) = p
            cs(p) = 0
            (ps, cs, curr)
          case ((ps, cs, prev), ((curr, p), i)) =>
            ps(i) = p
            cs(p) = cs(ps(i - 1)) + (if (prev == curr) 0 else 1)
            (ps, cs, curr)
        }
        go(iter + 1, ips, ics)

      case k if (1 << k) < n =>
        val xs = (0 until n).map(i => (cs(ps(i)) -> cs((ps(i) + (1 << k)) % n), ps(i))).sortBy(_._1)
        val (ips, ics, _) = xs.zipWithIndex.foldLeft((Array.fill(n)(0), Array.fill(n)(0), 0 -> 0)) {
          case ((ps, cs, _), ((curr, p), 0)) =>
            ps(0) = p
            cs(p) = 0
            (ps, cs, curr)
          case ((ps, cs, prev), ((curr, p), i)) =>
            ps(i) = p
            cs(p) = cs(ps(i - 1)) + (if (prev == curr) 0 else 1)
            (ps, cs, curr)
        }
        go(iter + 1, ips, ics)

      case _ => ps.map(i => str.slice(i, n))
    }

    go(-1)
  }

}
