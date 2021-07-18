package jp.atcoder.arc123.A

/** A - Arithmetic Sequence
  * https://atcoder.jp/contests/arc123/tasks/arc123_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a1, a2, a3) = readLine().split(" ").map(_.toLong)
  val (d1, d2)          = (a2 - a1, a3 - a2)

  val ans =
    if (d1 >= d2) d1 - d2
    else {
      val d = d2 - d1
      (d + d % 2) / 2 + d % 2
    }

  println(ans)
}
