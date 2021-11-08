package ru.yandex.contest.contest29964

import scala.collection.mutable.Queue

/** C. Сапёр
  * https://contest.yandex.ru/contest/29964/problems/C/
  */
object C extends App {

  type Field = Array[Array[Boolean]]

  implicit final class FieldOps(private val field: Field) extends AnyVal {

    def minesweeper: Int = {
      val n = field.length
      val m = field.headOption.map(_.length).getOrElse(0)
      val q = Queue.empty[(Int, Int)]

      @annotation.tailrec
      def open: Unit = if (q.nonEmpty) {
        val (r, c) = q.dequeue()
        field(r)(c) = false

        if (c > 0 && field(r)(c - 1)) { field(r)(c - 1) = false; q.enqueue((r, c - 1)) }
        if (r > 0 && field(r - 1)(c)) { field(r - 1)(c) = false; q.enqueue((r - 1, c)) }

        if (c < m - 1 && field(r)(c + 1)) { field(r)(c + 1) = false; q.enqueue((r, c + 1)) }
        if (r < n - 1 && field(r + 1)(c)) { field(r + 1)(c) = false; q.enqueue((r + 1, c)) }

        open
      }

      (0 until n).foldLeft(0) { (count, i) =>
        (0 until m).foldLeft(count) {
          case (count, j) if field(i)(j) =>
            q.enqueue((i, j))
            open
            count + 1
          case (count, _)                => count
        }
      }
    }
  }

  import InOut._

  val n = nextInt()
  val m = nextInt()
  val k = nextInt()

  val field = Array.fill(n, m)(true)
  (0 until k).foreach { _ =>
    val r = nextInt()
    val c = nextInt()
    field(r - 1)(c - 1) = false
  }

  val count = field.minesweeper

  out.println(count)
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
