package com.codeforces.round647div2

/** A. Johnny and Ancient Computer
  * - https://codeforces.com/contest/1362/problem/A
  */
object A extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val Array(a, b)  = scala.io.StdIn.readLine().split(" ").map(_.toLong.toBinaryString).sortBy(_.length)
    val (alen, blen) = (a.length, b.length)

    val (bl, br) = b.splitAt(alen)

    val ans =
      if (a != bl || br.contains('1')) -1
      else (blen - alen + 2) / 3

    println(ans)
  }
}
