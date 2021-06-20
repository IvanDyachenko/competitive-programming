package com.codeforces.round86edu

/** A. Road To Zero
  * - https://codeforces.com/contest/1342/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(x, y) = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val Array(a, b) = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    val ans = a * math.abs(x - y) + math.min(a + a, b) * math.min(x, y)

    println(ans)
  }
}
