package jp.atcoder.abc207.B

/** B - Hydrate
  * https://atcoder.jp/contests/abc207/tasks/abc207_b
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a, b, c, d) = readLine().split(" ").map(_.toInt)

  val t = c * d - b

  val ans =
    if (t <= 0) -1
    else (a + (t - 1)) / t

  println(ans)
}
