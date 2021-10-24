package com.codeforces.contest.round750div2

/** C. Grandma Capa Knits a Scarf
  * https://codeforces.com/contest/1582/problem/C
  */
object C extends App {

  def minimumNumberOfErasing(str: String): Option[Int] = {
    val size = str.size

    @annotation.tailrec
    def go(left: Int, right: Int, char: Char, count: Int = 0): Option[Int] =
      if (left >= right) Some(count)
      else
        (str(left), str(right)) match {
          case (leftChar, rightChar) if leftChar == rightChar => go(left + 1, right - 1, char, count)
          case (leftChar, _) if char == leftChar              => go(left + 1, right, char, count + 1)
          case (_, rightChar) if char == rightChar            => go(left, right - 1, char, count + 1)
          case _                                              => None
        }

    str.distinct.foldLeft[Option[Int]](None) { (countOpt, char) =>
      val candidateOpt = go(0, size - 1, char)
      candidateOpt.map { candidate => candidate min countOpt.getOrElse(candidate) }.orElse(countOpt)
    }
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextInt()
    val s = nextLine()

    minimumNumberOfErasing(s) match {
      case Some(count) => out.println(count)
      case _           => out.println(-1)
    }
  }

  out.flush()

  object InOut {
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
