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
    type Result = (Double, Int, Int)

    implicit final class PointArrayOps(private val points: Array[Point]) extends AnyVal {

      def closest: Option[Result] = {
        val byX = points.indices.sortBy(points)(orderingByX)
        val byY = points.indices.sortBy(points)(orderingByY)

        closest(byX, byY)
      }

      private[Point] def closest(byX: IndexedSeq[Int], byY: IndexedSeq[Int]): Option[Result] =
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

            val resultOpt = (closest(lteqByX, lteqByY), closest(gteqByX, gteqByY)) match {
              case (lteqResultOpt @ Some((lteqDist, _, _)), gteqResultOpt @ Some((gteqDist, _, _))) =>
                if (lteqDist < gteqDist) lteqResultOpt else gteqResultOpt
              case (resultOpt @ Some(_), _)                                                         => resultOpt
              case (_, resultOpt @ Some(_))                                                         => resultOpt
              case _                                                                                => None
            }

            resultOpt.map { case result @ (dist, _, _) =>
              val withinByY = byY.collect { case index if math.abs(points(index).x - at.x) <= dist => index }

              withinByY.indices.foldLeft(result) { (result, d) =>
                ((d + 1) until (withinByY.length min (d + 8))).foldLeft(result) { case (result @ (ab, _, _), c) =>
                  val cd = points(c) distance points(d)
                  if (cd < ab) (cd, c, d) else result
                }
              }
            }
        }

      private[Point] def closestBruteForce(indices: IndexedSeq[Int]): Option[Result] =
        indices.indices.foldLeft[Option[Result]](None) { (resultOpt, di) =>
          val d = indices(di)

          (0 until di).foldLeft(resultOpt) { (resultOpt, ci) =>
            val c  = indices(ci)
            val cd = points(c) distance points(d)

            resultOpt match {
              case Some((ab, _, _)) if cd >= ab => resultOpt
              case _                            => Some((cd, c, d))
            }
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
    case Some((ab, a, b)) =>
      out.println(f"${a min b} ${a max b} $ab%.6f")
      out.flush()
    case _                =>
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
