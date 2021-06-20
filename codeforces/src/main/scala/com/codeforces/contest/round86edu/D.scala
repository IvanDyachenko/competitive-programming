package com.codeforces.round86edu

/** D. Multiple Testcases
  * - https://codeforces.com/contest/1342/problem/D
  */
object D extends App {
  val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val mn          = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse)
  val ck          = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val (ans, _, _) = ck.reverse.zipWithIndex
    .foldLeft((0, 0, 0d)) { case ((b, j, g), (c, i)) =>
      val u = mn.indexWhere(_ < k - i, j)
      val t = if (u < 0) n else u
      val h = g + t - j

      (b max math.ceil(h / c).toInt, t, h)
    }

  val kv = collection.mutable.Map.empty[Int, List[Int]]

  mn.zipWithIndex.foreach { case (m, i) =>
    val k = i % ans
    val v = m :: kv.getOrElse(k, Nil)

    kv += (k -> v)
  }

  println(ans)

  kv.foreach { case (_, vs) =>
    println(s"${vs.length} ${vs.mkString(" ")}")
  }
}
