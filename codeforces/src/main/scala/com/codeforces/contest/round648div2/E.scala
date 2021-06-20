package com.codeforces.round648div2

/** E. Maximum Subsequence Value
  * - https://codeforces.com/contest/1365/problem/E
  */
object E extends App {
  val n  = scala.io.StdIn.readInt()
  val an = scala.io.StdIn.readLine().split(" ").map(_.toLong)

  val ans =
    if (n <= 3) an.reduce(_ | _)
    else {
      var c = 0L

      for {
        i <- 0 until n
        j <- i until n
        a  = an(i) | an(j)
        k <- j until n
        b  = a | an(k)
      } c = b max c

      c
    }

  println(ans)
}
