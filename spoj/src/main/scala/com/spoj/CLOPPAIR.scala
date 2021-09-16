package com.spoj

/** CLOPPAIR - Closest Point Pair
  * https://www.spoj.com/problems/CLOPPAIR/
  */
object CLOPPAIR extends App {

  case class Point(x: Int, y: Int) {
    def distance(that: Point): Double = {
      val xDelta = (x - that.x).toLong
      val yDelta = (y - that.y).toLong
      math.sqrt(xDelta * xDelta + yDelta * yDelta)
    }
  }

  object Point {

    implicit final class PointArrayOps(private val points: Array[Point]) extends AnyVal {

      def closest: Option[(Int, Int)] = {
        val byX = points.indices.sortBy(points)(orderingByX)
        val byY = points.indices.sortBy(points)(orderingByX)
        closest(byX, byY)
      }

      private[Point] def closest(byX: IndexedSeq[Int], byY: IndexedSeq[Int]): Option[(Int, Int)] =
        byX.length match {
          case l if l <= 3 => closestBruteForce(byX)
          case l           =>
            val at = points(byX(l >>> 1))

            val lteq: PartialFunction[Int, Int] = {
              case index if points(index).x < at.x || points(index).x == at.x && points(index).y < at.y => index
            }
            val gteq: PartialFunction[Int, Int] = {
              case index if points(index).x > at.x || points(index).x == at.x && points(index).y > at.y => index
            }

            val lteqByX = byX.collect(lteq)
            val lteqByY = byY.collect(lteq)

            val gteqByX = byX.collect(gteq)
            val gteqByY = byY.collect(gteq)

            val pairOpt = (closest(lteqByX, lteqByY), closest(gteqByX, gteqByY)) match {
              case (lteqPairOpt @ Some(lteqPair), gteqPairOpt @ Some(gteqPair)) =>
                val lteqDist = points(lteqPair._1) distance points(lteqPair._2)
                val gteqDist = points(gteqPair._1) distance points(gteqPair._2)
                if (lteqDist < gteqDist) lteqPairOpt else gteqPairOpt
              case (pairOpt @ Some(_), _)                                       => pairOpt
              case (_, pairOpt @ Some(_))                                       => pairOpt
              case _                                                            => None
            }

            pairOpt.map { pair =>
              val pairDist  = points(pair._1) distance points(pair._2)
              val withinByY = byY.collect { case index if math.abs(points(index).x - at.x) <= pairDist => index }

              withinByY.indices.foldLeft(pair) { (pair, d) =>
                ((d + 1) until (withinByY.length min (d + 8))).foldLeft(pair) { case (pair @ (a, b), c) =>
                  val ab = points(a) distance points(b)
                  val cd = points(c) distance points(d)
                  if (cd < ab) (c, d) else pair
                }
              }
            }
        }

      private[Point] def closestBruteForce(indices: IndexedSeq[Int]): Option[(Int, Int)] =
        indices.indices.foldLeft[Option[(Int, Int)]](None) { (pairOpt, di) =>
          (0 until di).foldLeft(pairOpt) {
            case (pairOpt @ Some((a, b)), ci) =>
              val (c, d) = (indices(ci), indices(di))
              val ab     = points(a) distance points(b)
              val cd     = points(c) distance points(d)
              if (cd < ab) Some((c, d)) else pairOpt
            case (_, ci)                      =>
              val (c, d) = (indices(ci), indices(di))
              Some((c, d))
          }
        }

    }

    implicit val orderingByX: Ordering[Point] = Ordering.by[Point, (Int, Int)] { case Point(x, y) => (x, y) }
    implicit val orderingByY: Ordering[Point] = Ordering.by[Point, (Int, Int)] { case Point(x, y) => (y, x) }
  }

  import InOut._

  val n  = nextInt()
  val pn = Array.fill(n) { val Array(x, y) = nextInts(2); Point(x, y) }

  pn.closest match {
    case Some((a, b)) =>
      val ab = BigDecimal(pn(a) distance pn(b)).setScale(6, BigDecimal.RoundingMode.HALF_UP)
      out.println(f"${a min b} ${a max b} $ab")
      out.flush()
    case _            =>
  }

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
