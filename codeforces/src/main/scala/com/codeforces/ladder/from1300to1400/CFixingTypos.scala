package com.codeforces.ladder.from1300to1400

/** C. Fixing Typos
  * https://codeforces.com/problemset/problem/363/C
  */
object CFixingTypos extends App {
  import scala.io.StdIn._

  val s = readLine()

  val ans = {
    s.tail
      .foldLeft((List(s.head), s.head, 1, false)) { case ((result, prev, count, status), curr) =>
        if (curr == prev && status) (result, curr, count, status)
        else if (curr == prev && count <= 1) (curr :: result, curr, count + 1, false)
        else if (curr != prev) (curr :: result, curr, 1, count == 2)
        else (result, curr, count, status)
      }
      ._1
      .reverse
      .mkString("")
  }

  println(ans)
}
