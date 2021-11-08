package ru.yandex.contest.contest29964

import scala.collection.mutable.ArrayDeque

/** F. Распределение курьеров по зонам доставки
  * https://contest.yandex.ru/contest/29964/problems/F/
  */
object F extends App {
  import InOut._

  val k = nextInt()
  val m = nextInt()
  val n = nextInt()

  val row2prefix = Array.fill(m)(nextInts(n).scanLeft(0)(_ + _))

  val q = ArrayDeque.empty[(Int, Int)]

  val result =
    (0 until n).foldLeft(0) { (sum, l) =>
      (l until n).foldLeft(sum) { (sum, r) =>
        val t = k / (r - l + 1)

        if (t == 0) sum
        else {
          q.clear()

          (0 to m)
            .foldLeft((sum, 0)) { case ((sum, pref), i) =>
              q.removeHeadWhile { case (j, _) => i - j > t }
              q.removeLastWhile { case (_, qref) => qref > pref }
              q.append(i -> pref)

              (
                sum max (pref - q.head._2),
                pref + (if (i == m) 0
                        else row2prefix(i)(r + 1) - row2prefix(i)(l))
              )
            }
            ._1
        }
      }
    }

  out.println(result)
  out.flush()

  object InOut {
    import java.util.Scanner

    val in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out = new java.io.PrintWriter(System.out, false)

    def nextInt()        = Integer.parseInt(nextToken())
    def nextInts(n: Int) = Array.fill(n)(nextInt())

    def nextLong()        = java.lang.Long.parseLong(nextToken())
    def nextLongs(n: Int) = Array.fill(n)(nextLong())

    def nextBig()        = BigInt(nextToken())
    def nextBigs(n: Int) = Array.fill(n)(nextBig())

    def nextLine() = in.readLine()

    private[this] var tokenizer: java.util.StringTokenizer = _

    private[this] def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}
