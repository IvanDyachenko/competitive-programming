package com.codeforces.ladder.from0to1300

/** B. Appleman and Card Game
  * - https://codeforces.com/problemset/problem/462/B
  */
object BApplemanAndCardGame extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val cards = {
    val cs = Array.fill(26)(0)
    readLine().split("").foreach(c => cs(c.head - 'A') += 1)
    cs.sorted(Ordering[Int].reverse)
  }

  val ans = {
    @annotation.tailrec
    def go(count: Int, position: Int, coins: Long): Long =
      if (count == 0 || position == n) coins
      else {
        val value = count min cards(position)
        go(count - value, position + 1, coins + value.toLong * value)
      }

    go(k, 0, 0L)
  }

  println(ans)
}
