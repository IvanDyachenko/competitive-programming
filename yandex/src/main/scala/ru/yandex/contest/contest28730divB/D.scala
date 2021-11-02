package ru.yandex.contest.contest28730divB

/** D. Строительство школы
  * https://contest.yandex.ru/contest/28730/problems/D/
  */
object D extends App {
  import InOut._

  val n  = nextInt()
  val cn = nextLongs(n)

  val optimal = cn(n / 2)
  out.println(optimal)
  out.flush()

  // val total = (1 until n).foldLeft(0L) { (total, index) => total + (cn(index) - cn(0)).abs }

  // val (optimalPosition, _, _) = (1 until n).foldLeft((0, total, total)) {
  //   case ((optimalPosition, optimalTotal, previousTotal), currentPosition) =>
  //     val previousPosition = currentPosition - 1
  //     val offset           = (cn(currentPosition) - cn(previousPosition)).abs
  //     val currentTotal     = previousTotal + offset * (2L * currentPosition - n)

  //     if (currentTotal < optimalTotal)
  //       (currentPosition, currentTotal, currentTotal)
  //     else
  //       (optimalPosition, optimalTotal, currentTotal)
  // }

  // val optimalСoordinate = cn(optimalPosition)

  // out.println(optimalСoordinate)
  // out.flush()

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
