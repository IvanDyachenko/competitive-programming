package ru.yandex.contest.contest27049

/** B. Разбиение на интервалы дат
  * https://contest.yandex.ru/contest/27049/problems/B/
  */
object B extends App {

  import java.time.{LocalDate, Period, DayOfWeek}
  import java.time.format.DateTimeFormatter
  import java.time.temporal.{TemporalAdjuster, TemporalAdjusters, IsoFields}

  import java.util.function.UnaryOperator

  import scala.jdk.StreamConverters._

  sealed trait Split {
    def end: LocalDate
    def start: LocalDate

    def period: Period
    def adjuster: TemporalAdjuster

    def from: LocalDate  = start `with` adjuster
    def until: LocalDate = end plusDays 1

    def intervals: List[(LocalDate, LocalDate)] = {
      val dates = start +: (if (until isBefore from) Nil else from.datesUntil(until, period).toScala(List)) :+ until
      (dates zip dates.tail).map { case (left, right) => (left, right minusDays 1) }
    }
  }

  final case class Week(start: LocalDate, end: LocalDate) extends Split {
    val period   = Period.ofWeeks(1)
    val adjuster = TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)
  }

  final case class Month(start: LocalDate, end: LocalDate) extends Split {
    val period   = Period.ofMonths(1)
    val adjuster = TemporalAdjusters.firstDayOfNextMonth()
  }

  final case class Quarter(start: LocalDate, end: LocalDate) extends Split {
    val period   = Period.ofMonths(3)
    val adjuster = TemporalAdjusters.ofDateAdjuster((date: LocalDate) => {
      val quarter = date.get(IsoFields.QUARTER_OF_YEAR)
      date.withMonth(3 * quarter).`with`(TemporalAdjusters.firstDayOfNextMonth())
    })
  }

  final case class Review(start: LocalDate, end: LocalDate) extends Split {
    val period   = Period.ofMonths(6)
    val adjuster = TemporalAdjusters.ofDateAdjuster { (date: LocalDate) =>
      {
        date.get(IsoFields.QUARTER_OF_YEAR) match {
          case 1     => date.withMonth(4)
          case 4     => date.plusYears(1).withMonth(4)
          case 2 | 3 => date.withMonth(10)
        }
      }.`with`(TemporalAdjusters.firstDayOfMonth())
    }
  }

  final case class Year(start: LocalDate, end: LocalDate) extends Split {
    val period   = Period.ofYears(1)
    val adjuster = TemporalAdjusters.firstDayOfNextYear()
  }

  object Split {
    val Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    def parse(kind: String, input: String): Split = {
      val Array(start, end) = input.split(" ").map(LocalDate.parse(_, Formatter))

      kind match {
        case "WEEK"    => Week(start, end)
        case "MONTH"   => Month(start, end)
        case "QUARTER" => Quarter(start, end)
        case "REVIEW"  => Review(start, end)
        case "YEAR"    => Year(start, end)
      }
    }
  }

  import InOut._

  val kind  = nextLine()
  val input = nextLine()

  val intervals = Split.parse(kind, input).intervals

  out.println(intervals.length)
  intervals.foreach { case (from, to) => out.println(s"${Split.Formatter.format(from)} ${Split.Formatter.format(to)}") }
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
