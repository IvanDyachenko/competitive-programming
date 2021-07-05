package com.codeforces.contest.round729div2

/** C. Strange Function
  * https://codeforces.com/contest/1542/problem/C
  *
  * https://codeforces.com/blog/entry/92492?#comment-811837
  * https://codeforces.com/blog/entry/92492?#comment-811605:
  *   If f(i)=x, it means that i has divisors 2,3,4,...,x-1, so
  *   i>=lcm(2,3,4,...,x-1). In other words, 2,3,...,x-1 must be
  *   divisors of i, that is lcm(1,2,...,x-1) divides i.
  *
  *   The number of elements that are divisible by 2,3,...,x is
  *   n/lcm(1,2,...,x).
  *
  *   Thus we can iterate over x and each time count how many such i
  *   for each x, which is n/lcm(1,...,x-1) - n/lcm(1,...,x).
  */
object C extends App {
  import scala.io.StdIn._

  @annotation.tailrec
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  def lcm(a: Long, b: Long): Long = a / gcd(a, b) * b

  val Mod = (1e9 + 7).toLong
  val t   = readInt()

  (0 until t).foreach { _ =>
    val n = readLong()

    val ans = {
      @annotation.tailrec
      def go(y: Long, lcmx: Long = 1L, result: Long = 0L): Long =
        if (lcmx > n) result
        else {
          val lcmy  = lcm(lcmx, y)
          val count = n / lcmx - n / lcmy
          go(y + 1, lcmy, (result + y * count % Mod) % Mod)
        }

      go(2L)
    }

    println(ans)
  }
}
