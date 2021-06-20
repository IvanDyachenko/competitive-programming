package com.codeforces.round630div2

/** C. K-Complete Word
  * - https://codeforces.com/contest/1332/problem/C
  */
object C extends App {

  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val s           = scala.io.StdIn.readLine()

    val ans = s.zipWithIndex
      .foldLeft(Array.fill((k + 1) / 2)(List.empty[Char])) { case (ls, (s, i)) =>
        ls((i % k).min(k - i % k - 1)) ::= s
        ls
      }
      .foldLeft(0)(
        _ + _.groupBy(identity).values.toList.sortBy(_.length)(Ordering.Int.reverse).tail.foldLeft(0)(_ + _.length)
      )

    println(ans)

  }

}
