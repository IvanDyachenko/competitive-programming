package ru.yandex.contest.contest28730divB

/** E. Точка и треугольник
  * https://contest.yandex.ru/contest/28730/problems/E/
  */
object E extends App {
  import InOut._

  val d = nextInt()
  val x = nextInt()
  val y = nextInt()

  if (x >= 0 && y >= 0 && d >= x + y)
    out.println(0)
  else {
    val distances = List(
      (x * x + y * y, 1),
      ((x - d) * (x - d) + y * y, 2),
      (x * x + (y - d) * (y - d), 3)
    )
    out.println(distances.min._2)
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
