package com.codeforces.ladder.from0to1300

/** A. Beautiful Year
  * - https://codeforces.com/problemset/problem/271/A
  */
object ABeautifulYear extends App {
  import scala.io.StdIn._

  val y = readInt()

  val ans = ((y + 1) to 9012).collectFirst {
    case x if x.toString.distinct.length == 4 => x.toString
  }.get

  println(ans)
}
