package com.codeforces.ladder.from0to1300

/** A. Perfect Permutation
  * - https://codeforces.com/problemset/problem/233/A
  */
object APerfectPermutation extends App {
  import scala.io.StdIn._

  val n = readInt()

  val ans =
    if (n % 2 == 0)
      (1 to n).map(i => if (i % 2 == 0) i - 1 else i + 1)
    else
      IndexedSeq(-1)

  println(ans.mkString(" "))
}
