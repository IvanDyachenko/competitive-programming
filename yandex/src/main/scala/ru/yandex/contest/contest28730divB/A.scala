package ru.yandex.contest.contest28730divB

/** A. Interactor
  * https://contest.yandex.ru/contest/28730/problems/A/
  */
object A extends App {
  import InOut._

  val exit       = nextInt()
  val interactor = nextInt()
  val checker    = nextInt()

  val result = (interactor, checker, exit) match {
    case (0, checker, 0)    => checker
    case (1, checker, _)    => checker
    case (4, _, 0)          => 4
    case (0 | 4, _, _)      => 3
    case (6, _, _)          => 0
    case (7, _, _)          => 1
    case (interactor, _, _) => interactor
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
