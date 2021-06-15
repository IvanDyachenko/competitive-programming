package com.codeforces.ladder.from0to1300

/** B. Jzzhu and Sequences
  * - https://codeforces.com/problemset/problem/450/B
  */
object BJzzhuAndSequences extends App {
  import scala.io.StdIn._

  val Mod         = 1000000007
  val Array(x, y) = readLine().split(" ").map(_.toInt)
  val n           = readInt()

  def mod(x: Int): Int = (x % Mod + Mod) % Mod

  //lazy val f: Stream[Int] = mod(x) #:: mod(y) #:: (f zip f.tail).map { case (x, y) => mod(y - x) }

  val f: Int => Int = {
    val numbers = Array(mod(x), mod(y), mod(y - x), mod(-x), mod(-y), mod(x - y))
    (i: Int) => numbers(i % 6)
  }

  val ans = f(n - 1)

  println(ans)
}
