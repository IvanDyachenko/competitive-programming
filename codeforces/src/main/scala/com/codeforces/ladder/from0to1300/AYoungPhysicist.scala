package com.codeforces.ladder.from0to1300

/** A. Young Physicist
  * - https://codeforces.com/problemset/problem/69/A
  */
object AYoungPhysicist extends App {
  import scala.io.StdIn._

  val n     = readInt()
  val force = (0 until n).foldLeft((0, 0, 0)) { case ((sx, sy, sz), _) =>
    val Array(x, y, z) = readLine().split(" ").map(_.toInt)
    (sx + x, sy + y, sz + z)
  }

  val ans = force match {
    case (0, 0, 0) => "YES"
    case _         => "NO"
  }

  println(ans)
}
