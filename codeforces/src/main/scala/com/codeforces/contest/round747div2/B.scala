package com.codeforces.contest.round747div2

/** B. Special Numbers
  * https://codeforces.com/contest/1594/problem/B
  */
object B extends App {

  lazy val Mod = (1e9 + 7).toLong

  def kthSpecialNumber(n: Int, k: Int): Long =
    (0 to 31)
      .foldLeft((0L, 1L)) {
        case ((result, power), i) if (1 & (k >> i)) == 1 => ((result + power) % Mod, (n * power) % Mod)
        case ((result, power), _)                        => (result, (n * power) % Mod)
      }
      ._1

  ///////////////////////////////////////////////////////////////////////////
  // def log2(n: Int): Int = 31 - Integer.numberOfLeadingZeros(n)          //
  //                                                                       //
  // def specialNumbers(n: Int, k: Int): Long = {                          //
  //                                                                       //
  //   val powers: Array[Long] = {                                         //
  //     val size = log2(k) + 1                                            //
  //     val data = Array.fill(size)(1L)                                   //
  //     (1 until size).foreach { i => data(i) = (n * data(i - 1)) % Mod } //
  //     data                                                              //
  //   }                                                                   //
  //                                                                       //
  //   @annotation.tailrec                                                 //
  //   def go(k: Int, result: Long): Long = k match {                      //
  //     case 0 => result                                                  //
  //     case k =>                                                         //
  //       val l = log2(k)                                                 //
  //       val i = k - (1 << l)                                            //
  //                                                                       //
  //       go(i, (result + powers(l)) % Mod)                               //
  //   }                                                                   //
  //                                                                       //
  //   go(k, 0L)                                                           //
  // }                                                                     //
  ///////////////////////////////////////////////////////////////////////////

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextInt()
    val k = nextInt()

    out.println(kthSpecialNumber(n, k))
  }

  out.flush()

  final object InOut {
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

    def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}
