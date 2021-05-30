package jp.atcoder.abc203.B

/** B - AtCoder Condominium
  * - https://atcoder.jp/contests/abc203/tasks/abc203_b
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(n, k) = readLine().split(" ").map(_.toInt)

  val p = (1 to k).sum
  val q = (1 to n).sum

  val ans = n * p + 100 * k * q

  println(ans)
}
