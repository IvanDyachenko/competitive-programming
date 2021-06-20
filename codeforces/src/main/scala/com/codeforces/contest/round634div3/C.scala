package com.codeforces.round634div3

/** C. Two Teams Composing
  * - https://codeforces.com/contest/1335/problem/C
  */
object C extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n      = scala.io.StdIn.readInt()
    val skills = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    val l :: rs =
      skills
        .groupBy(identity)
        .valuesIterator
        .map(_.length)
        .toList
        .sorted(Ordering.Int.reverse)

    val r = rs.length

    val answer =
      if (r >= l) l
      else if (l - r > 1) r + 1
      else r

    println(answer)
  }
}
