package jp.atcoder.abc203.C

/** C - Friends and Travel costs
  * - https://atcoder.jp/contests/abc203/tasks/abc203_c
  */
object Main extends App {
  import scala.io.StdIn._

  private def last(fs: List[(Long, Long)], i: Long, yen: Long): Long =
    fs match {
      case (ai, bi) :: ts if ai == i      => last(ts, i, yen + bi)
      case (ai, bi) :: _ if i + yen >= ai => last(fs, ai, yen - (ai - i))
      case _                              => i + yen
    }

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val friends     = (0 until n)
    .foldLeft(List.empty[(Long, Long)]) { case (fs, _) =>
      val Array(ai, bi) = readLine().split(" ").map(_.toLong)
      (ai, bi) :: fs
    }
    .sortBy(_._1)

  val ans = last(friends, 0, k)

  println(ans)
}
