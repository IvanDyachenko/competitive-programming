package com.codeforces.round632div2

/** C. Eugene and an array
  * - https://codeforces.com/contest/1333/problem/C https://codeforces.com/blog/entry/75802
  */
object C extends App {

  implicit class SetOps[A](val set: Set[A]) extends AnyVal {

    def fillWhile(xs: List[A]): (List[A], Set[A]) = xs match {
      case Nil     => (Nil, set)
      case x :: rs =>
        if (set.contains(x)) (xs, set) else (set + x).fillWhile(rs)
    }
  }

  private def howGood(as: List[Int]): Long = {

    @scala.annotation.tailrec
    def go(ps: List[Long], qs: List[Long], s: Set[Long] = Set(0L), acc: Long = 0L): Long = ps match {
      case Nil     => acc
      case x :: xs =>
        val (nqs, ns) = s.fillWhile(qs)
        go(xs, nqs, ns - x, acc + ns.size - 1)
    }

    val ps = as.scanLeft(0L)(_ + _)

    go(ps, ps.tail)
  }

  val n  = scala.io.StdIn.readInt()
  val as = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

  println(howGood(as))
}
