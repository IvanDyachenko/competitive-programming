package com.codeforces.ladder.from1300to1400

/** B. Routine Problem
  * https://codeforces.com/problemset/problem/337/B
  */
object BRoutineProblem extends App {
  import scala.io.StdIn._

  @annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private def lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

  val Array(a, b, c, d) = readLine().split(" ").map(_.toInt)

  val (p, q) = {
    val (p, q) =
      if (b * c > d * a) (b * c - d * a, c * b)
      else if (d * a > b * c) (d * a - b * c, a * d)
      else (0, 0)

    val g = gcd(p, q)

    gcd(p, q) match {
      case 0 => (0, 1)
      case g => (p / g, q / g)
    }
  }

  println(s"$p/$q")
}
