package com.codeforces.round641div2

/** C. Orac and LCM
  * - https://codeforces.com/contest/1350/problem/C
  * - https://codeforces.com/blog/entry/77284?#comment-620958 https://codeforces.com/blog/entry/77284?#comment-621269
  * - https://codeforces.com/contest/1349/submission/79820899
  */
object C extends App {

  private def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  private def lcm(a: Long, b: Long): Long = a / gcd(a, b) * b

  val n  = scala.io.StdIn.readInt()
  val an = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  // gcd of { lcm(a1, a2), ..., lcm(a1, an), ..., lcm(ai, ai+1), ..., lcm(ai, an), ..., lcm(an-1, an) } =
  // gcd of { gcd of { lcm(a1, a2), lcm(a1, a3), ..., lcm(a1, an) }, ..., gcd of { lcm(ai, ai+1), lcm(ai, ai+2), ..., lcm(ai, an) }, ... }
  val ans = an.indices
    .foldLeft((0L, 0L)) { case ((ans, g), i) =>
      // gcd of { lcm(ai, ai+1), lcm(ai, ai+2), ..., lcm(ai, an) } =
      // lcm of { ai, gcd of { ai+1, ai+2, ..., an } }
      (gcd(ans, lcm(an(i), g)), gcd(g, an(i)))
    }
    ._1

  println(ans)
}
