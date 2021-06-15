package com.codeforces.ladder.from0to1300

/** A. Word Capitalization
  * - https://codeforces.com/problemset/problem/281/A
  */
object AWordCapitalization extends App {
  import scala.io.StdIn._

  val s   = readLine()
  val ans = (if (s.head > 95) (s.head - 32).toChar else s.head) + s.tail

  println(ans)
}
