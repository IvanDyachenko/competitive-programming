package jp.atcoder.abc208.A

/** A - Rolling Dice
  * https://atcoder.jp/contests/abc208/tasks/abc208_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a, b) = readLine().split(" ").map(_.toInt)

  val ans = a <= b && b <= 6 * a
  // {
  //   val (d, r) = (b / 6, b % 6)
  //   val t      = d + (if (r == 0) 0 else 1)
  //   t <= a && a <= b
  // }

  ans match {
    case true => println("Yes")
    case _    => println("No")
  }
}
