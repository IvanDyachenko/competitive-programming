package com.codeforces.round633div2

/** C. Powered Addition
  * - https://codeforces.com/contest/1339/problem/C
  */
object C extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n         = scala.io.StdIn.readInt()
    val an        = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val (_, diff) = an.tail.foldLeft((an.head, 0)) { case ((p, d), c) => if (c >= p) (c, d) else (p, d.max(p - c)) }
    val sec       = 1 + -1.max(math.floor(math.log10(diff) / math.log10(2)).toInt)

    println(sec)
  }
}
