package com.codeforces.ladder.from0to1300

/** A. Word
  * - https://codeforces.com/problemset/problem/59/A
  */
object AWord extends App {
  import scala.io.StdIn._

  val s = readLine()

  val ans =
    if (s.count(_ < 95) > s.length / 2)
      s.map(c => if (c > 95) (c - 32).toChar else c)
    else
      s.map(c => if (c < 95) (c + 32).toChar else c)

  println(ans)
}
