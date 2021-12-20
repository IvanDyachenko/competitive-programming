package com.codeforces.contest.round762div3

/** C. Wrong Addition
  * https://codeforces.com/contest/1619/problem/C
  */
object C extends App {
  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val a = nextLong()
    val s = nextLong()

    s.augend(a) match {
      case Some(b) => out.println(b)
      case _       => out.println(-1)
    }
  }

  out.flush()

  implicit final class LongOps(private val sum: Long) extends AnyVal {
    def digits: List[Byte] = sum.toString().split("").map(_.toByte).toList

    def augend(addend: Long): Option[Long] = {
      @annotation.tailrec
      def go(sumDigits: List[Byte], addendDigits: List[Byte], augendDigits: List[Byte]): Option[List[Byte]] =
        (sumDigits, addendDigits) match {
          case (sumHead :: sumTail, addendHead :: addendTail) if addendHead <= sumHead =>
            go(sumTail, addendTail, (sumHead - addendHead).toByte :: augendDigits)
          case (sumFirst :: sumSecond :: sumTail, addendHead :: addendTail)            =>
            val sumHead = sumSecond * 10 + sumFirst
            if (sumHead > 18 || addendHead > sumHead) None
            else go(sumTail, addendTail, (sumHead - addendHead).toByte :: augendDigits)
          case (sumHead :: sumTail, _)                                                 =>
            go(sumTail, addendDigits, sumHead :: augendDigits)
          case _                                                                       =>
            if (addendDigits.isEmpty) Some(augendDigits) else None
        }

      go(sum.digits.reverse, addend.digits.reverse, List.empty[Byte]).map(_.mkString("").toLong)
    }
  }

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
