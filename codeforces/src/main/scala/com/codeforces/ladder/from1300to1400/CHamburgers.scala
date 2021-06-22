package com.codeforces.ladder.from1300to1400

/** C. Hamburgers
  * https://codeforces.com/problemset/problem/371/C
  */
object CHamburgers extends App {
  import scala.io.StdIn._

  val (rb, rs, rc) = {
    val r = scala.collection.mutable.Map('B' -> 0L, 'S' -> 0L, 'C' -> 0L)
    readLine().foreach(c => r(c) += 1L)
    (r('B'), r('S'), r('C'))
  }
  val Array(nb, ns, nc) = readLine().split(" ").map(_.toLong)
  val Array(pb, ps, pc) = readLine().split(" ").map(_.toLong)
  val r                 = readLong()

  def search(f: Long => Boolean): Long = {
    @annotation.tailrec
    def go(l: Long, r: Long): Long =
      if (l + 1 >= r) l
      else {
        val m = (l + r) / 2

        f(m) match {
          case true => go(m, r)
          case _    => go(l, m)
        }
      }

    val r = {
      @annotation.tailrec
      def go(r: Long): Long = if (f(r)) go(r << 2) else r
      go(1L)
    }

    go(-1, r)
  }

  def f(i: Long): Boolean = r - (i * rb - nb).max(0) * pb - (i * rs - ns).max(0) * ps - (i * rc - nc).max(0) * pc >= 0

  val ans = search(f)

  println(ans)
}
