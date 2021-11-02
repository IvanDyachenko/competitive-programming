package ru.yandex.contest.contest8458

/** D. Генерация скобочных последовательностей
  * https://contest.yandex.ru/contest/8458/problems/D/
  */
object D extends App {
  import InOut._

  def catalan(n: Int): Int = {
    val (numerator, denominator) = (2 to n).foldLeft((1L, 1L)) { case ((num, den), x) =>
      (num * (n + x), den * x)
    }
    (numerator / denominator).toInt
  }

  def getNextBracket(bracket: String): String = {
    @annotation.tailrec
    def go(position: Int, opened: Int = 0, closed: Int = 0): String =
      bracket(position) match {
        case ')'                         => go(position - 1, opened, closed + 1)
        case '(' if closed <= opened + 1 => go(position - 1, opened + 1, closed)
        case '('                         =>
          val left   = bracket.slice(0, position)
          val middle = "(" * (opened + 1)
          val right  = ")" * (closed - 1)
          s"$left)$middle$right"

      }

    go(bracket.length - 1)
  }

  val n = nextInt()

  val initBracket = "(" * n + ")" * n
  out.println(initBracket)

  (1 until catalan(n)).foldLeft(initBracket) { (bracket, _) =>
    val nextBracket = getNextBracket(bracket)
    out.println(nextBracket)
    nextBracket
  }

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
