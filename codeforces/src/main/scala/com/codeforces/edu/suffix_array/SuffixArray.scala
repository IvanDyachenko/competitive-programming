package com.codeforces.edu.suffix_array

object SuffixArray {

  def suffixes(str: String): Seq[String] = {
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
