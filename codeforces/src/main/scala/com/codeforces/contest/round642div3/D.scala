package com.codeforces.round642div3

/** D. Constructing the Array
  * - https://codeforces.com/contest/1353/problem/D
  */
object D extends App {
  import scala.collection.mutable.TreeSet

  implicit val ord = Ordering.by[(Int, Int), (Int, Int)] { case (l, r) => (l - r + 1, l) }

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n = scala.io.StdIn.readInt()

    var an   = Array.fill[Int](n)(0)
    var segs = TreeSet[(Int, Int)]((0, n - 1))(ord)

    (1 to n).foreach { v =>
      val (l, r) = segs.head

      val i = (l + r) / 2

      segs -= ((l, r))
      if (i > l) segs += ((l, i - 1))
      if (i < r) segs += ((i + 1, r))

      an(i) = v
    }

    println(an.mkString(" "))
  }
}
