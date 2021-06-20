package com.codeforces.contest.round672div2

/** B. Rock and Lever
  * - https://codeforces.com/contest/1420/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  def higher(a: Int): Int = {
    @annotation.tailrec
    def go(h: Int): Int = if (1 << h > a) h else go(h + 1)
    go(1)
  }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(s => higher(s.toInt))

    val bits = Array.fill(32)(0)

    val ans = an.foldLeft(0L) { case (count, h) =>
      bits(h) += 1
      count + bits(h) - 1
    }

    println(ans)
  }
}
