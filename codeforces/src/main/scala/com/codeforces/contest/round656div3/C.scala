package com.codeforces.round656div3

/** C. Make It Good
  * - https://codeforces.com/contest/1385/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val i = an.zipWithIndex.lastIndexWhere {
      case (_, 0) => true
      case (a, i) => a > an(i - 1)
    }

    val j = an.zipWithIndex.lastIndexWhere(
      {
        case (_, 0) => true
        case (a, j) => a < an(j - 1)
      },
      i
    )

    println(j)
  }
}
