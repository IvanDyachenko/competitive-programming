package com.codeforces.round643div2

/** D. Game With Array
  * - https://codeforces.com/contest/1355/problem/D
  * - https://codeforces.com/blog/entry/77491?#comment-625012
  */
object D extends App {
  val Array(n, s) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val an =
    if (s >= 2 * n) (s - 2 * n + 2) :: List.fill(n - 1)(2)
    else List.empty

  if (an.isEmpty) println("NO")
  else {
    println("YES")
    println(an.mkString(" "))
    println(1)
  }
}
