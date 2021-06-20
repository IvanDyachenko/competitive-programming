package com.codeforces.edu.suffix_array.step2

/** A. Suffix Array - 2
  * - https://codeforces.com/edu/course/2/lesson/2/2/practice/contest/269103/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  def suffixes(str: String): Seq[Int] = {
    val s = str + "$"
    val n = s.length

    var ps = Array.ofDim[Int](n)
    var cs = Array.ofDim[Int](n)

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
    def go(iter: Int): Seq[Int] =
      if (1 << iter > n) ps
      else {
        var sp = Array.ofDim[Int](n)
        var sc = Array.ofDim[Int](n)

        ps.indices.foreach(i => ps(i) = (ps(i) - (1 << iter) + n) % n)

        //////////////////////////////
        //      Counting  Sort      //
        //                          //
        val xs = Array.fill(n)(0)
        cs.foreach(c => xs(c) += 1)

        val is = xs.scanLeft(0)(_ + _)

        ps.foreach { p =>
          val c = cs(p)

          sp(is(c)) = p
          is(c) += 1
        }
        //                          //
        //////////////////////////////

        sp.indices.foreach {
          case 0 => sc(sp(0)) = 0
          case i =>
            val (p, q) = (sp(i), sp(i - 1))

            val curr = cs(p) -> cs((p + (1 << iter)) % n)
            val prev = cs(q) -> cs((q + (1 << iter)) % n)

            sc(p) = sc(q) + (if (curr == prev) 0 else 1)
        }

        ps = sp
        cs = sc

        go(iter + 1)
      }

    go(0)
  }

  val ans = suffixes(readLine())

  println(ans.mkString(" "))
}
