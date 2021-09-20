package com.codeforces.contest.round114edu

/** C. Slay the Dragon
  * https://codeforces.com/contest/1574/problem/C
  */
object C extends App {

  def slayTheDragon(heroes: IndexedSeq[Long]): (Long, Long) => Long = {

    def search(from: Int, to: Int, f: Int => Boolean): Int = {
      @annotation.tailrec
      def go(left: Int, right: Int): Int =
        if (left + 1 >= right) right
        else {
          val middle = (left + right) >>> 1

          f(middle) match {
            case true  => go(left, middle)
            case false => go(middle, right)
          }
        }
      go(from, to)
    }

    val heroesSorted  = heroes.sorted
    val heroesOverall = heroes.sum

    (dragonDefense: Long, dragonAttack: Long) => {
      val index = search(0, heroes.length - 1, heroesSorted(_) >= dragonDefense)

      def coins(index: Int): Long = {
        val hero = heroesSorted(index)
        0L.max(dragonDefense - hero) + 0L.max(dragonAttack - heroesOverall + hero)
      }

      coins(index) min coins(0 max (index - 1))
    }
  }

  import InOut._

  val n  = nextInt()
  val hn = nextLongs(n)

  lazy val coins = slayTheDragon(hn)

  val m = nextInt()

  (0 until m).foreach { _ =>
    val Array(x, y) = nextLongs(2)

    out.println(coins(x, y))
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
