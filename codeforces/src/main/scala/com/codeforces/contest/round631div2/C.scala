package com.codeforces.round631div2

/** C. Dreamoon Likes Coloring
  * - https://codeforces.com/contest/1330/problem/C https://codeforces.com/blog/entry/75559
  */
object C extends App {

  /** @param n  The number of cells.
    * @param ls Operational parameters.
    */
  private def colorize(n: Int, ls: Seq[Int]): Seq[Int] = {
    val ml = ls.zipWithIndex.map { case (l, i) => l + i }.max

    if (ml > n) Seq(-1)
    else {
      val suffix = ls.scanRight(0L)(_ + _)

      if (suffix.head < n) Seq(-1)
      else
        (1 to ls.length).zip(suffix).map { case (i, si) =>
          ((n + 1L - si) max i).toInt
        }
    }
  }

  val Array(n, _) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val ls          = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val ps = colorize(n, ls)

  println(ps.mkString(" "))
}
