package com.codeforces.round86edu

/**
  * D. Multiple Testcases
  * https://codeforces.com/contest/1342/problem/D
  */
object D extends App {
  val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val mn          = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted(Ordering.Int.reverse)
  val ck          = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val ans = ck.reverse.zipWithIndex
    .foldLeft((mn, 0d, 0)) {
      case ((mn, g, b), (c, i)) =>
        val mm = mn.dropWhile(_ >= (k - i))
        val t  = g + mn.length - mm.length
 
        (mm, t, b.max(math.ceil(t / c.toInt).toInt))
    }
    ._3

  val kv = collection.mutable.Map.empty[Int, List[Int]]

  mn.zipWithIndex.foreach {
    case (m, i) =>
      val k = i % ans
      val v = m :: kv.getOrElse(k, Nil)

      kv += (k -> v)
  }

  println(ans)

  kv.foreach {
    case (_, vs) =>
      println(s"${vs.length} ${vs.mkString(" ")}")
  }
}
