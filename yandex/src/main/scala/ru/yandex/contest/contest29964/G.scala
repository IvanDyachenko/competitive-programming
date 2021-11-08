package ru.yandex.contest.contest29964

/** G. Бонусы для водителей
  * https://contest.yandex.ru/contest/29964/problems/G/
  */
object G extends App {

  type Rating = Int

  implicit final class RatingsOps(private val ratings: Array[Rating]) extends AnyVal {

    def bonuses(base: Int): Long = {
      val n = ratings.length

      val ln = Array.fill(n)(1)
      val rn = Array.fill(n)(1)

      (1 until n).foreach { i =>
        val j = n - i - 1

        ln(i) = if (ratings(i) > ratings(i - 1)) ln(i - 1) + 1 else 1
        rn(j) = if (ratings(j) > ratings(j + 1)) rn(j + 1) + 1 else 1
      }

      ratings.indices.foldLeft(0L) { (sum, i) => sum + 1L * base * (ln(i) max rn(i)) }
    }
  }

  import InOut._

  val n  = nextInt()
  val rn = nextInts(n)

  val b = rn.bonuses(500)

  out.println(b)
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
