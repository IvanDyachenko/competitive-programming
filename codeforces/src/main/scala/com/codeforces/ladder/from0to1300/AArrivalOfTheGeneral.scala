package com.codeforces.ladder.from0to1300

/** A. Arrival of the General
  * - https://codeforces.com/problemset/problem/144/A
  */
object AArrivalOfTheGeneral extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt)

  val ((_, h), (_, l)) = an.tail.zipWithIndex.foldLeft((an.head, 0), (an.head, 0)) {
    case (state @ ((higher, h), (lower, l)), (height, i)) =>
      if (height > higher) ((height, i + 1), state._2)
      else if (height <= lower) (state._1, (height, i + 1))
      else state
  }

  val ans = h + (n - l - 1) - (if (l <= h) 1 else 0)

  println(ans)
}
