package com.codeforces.round650div3

/** D. Task On The Board
  * - https://codeforces.com/contest/1367/problem/D
  */
object D extends App {
  import scala.io.StdIn._

  val q = readInt()

  (0 until q).foreach { _ =>
    val s  = readLine()
    val m  = readInt()
    var bm = readLine().split(" ").map(_.toInt)

    var t    = Array.ofDim[Char](m)
    val freq = s.distinct.sorted(Ordering.Char.reverse).map(c => (c, s.count(c == _))).toArray

    (0 until m).foldLeft(0) { case (prev, _) =>
      val is           = bm.zipWithIndex.collect { case (b, i) if b == 0 => i }
      val (sub, islen) = (is.sum, is.length)
      val curr         = freq.indexWhere(_._2 >= islen, prev)

      is.foreach(t(_) = freq(curr)._1)

      (0 until m).foreach { j =>
        bm(j) = bm(j) match {
          case -1 | 0 => -1
          case b      => b - (j * islen - sub).abs
        }
      }

      curr + 1
    }

    println(t.mkString)
  }
}
