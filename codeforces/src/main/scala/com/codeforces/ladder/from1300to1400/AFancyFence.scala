package com.codeforces.ladder.from1300to1400

/** A. Fancy Fence
  * - https://codeforces.com/problemset/problem/270/A
  */
object AFancyFence extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val a = readInt()

    val ans =
      if (a < 180) {
        val (d, r) = (360 / (180 - a), 360 % (180 - a))

        if (d > 2 && r == 0) "YES"
        else "NO"
      } else "NO"

    println(ans)
  }
}
