package com.codeforces.round647div2

/** B. Johnny and His Hobbies
  * - https://codeforces.com/contest/1362/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val sn = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val t  = sn.reduce(_ ^ _)
    val m  = 1 << (1 + (math.log10(sn.max) / math.log10(2)).toInt)

    val k = (if (t == 0) (1 to m) else (t to t)).view.collectFirst { case k if sn.diff(sn.map(_ ^ k)).isEmpty => k }
      .getOrElse(-1)

    println(k)
  }
}
