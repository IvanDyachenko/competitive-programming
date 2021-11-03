package ru.yandex.contest.contest28738divB

/** B. Дома и магазины
  * https://contest.yandex.ru/contest/28738/problems/B/
  */
object B extends App {
  import InOut._

  val n      = 10
  val avenue = nextInts(n)

  val prefixes = avenue.zipWithIndex
    .scanLeft(-1) {
      case (previous, (2, index)) => index
      case (previous, _)          => previous
    }
    .drop(1)

  val suffixes = avenue.zipWithIndex
    .scanRight(-1) {
      case ((2, index), previous) => index
      case (_, previous)          => previous
    }

  val maximal = avenue.zipWithIndex
    .foldLeft(0) {
      case (maximal, (1, index)) =>
        val distance = (prefixes(index), suffixes(index)) match {
          case (-1, right)   => right - index
          case (left, -1)    => index - left
          case (left, right) => (right - index) min (index - left)
        }
        distance max maximal
      case (maximal, _)          => maximal
    }

  out.println(maximal)
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
