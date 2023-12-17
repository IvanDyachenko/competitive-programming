package com.adventofcode.year2023.day05

import com.adventofcode.year2023.day05.Part2.Converters.{
  SeedToSoil,
  SoilToFertilizer,
  FertilizerToWater,
  WaterToLight,
  LightToTemperature,
  TemperatureToHumidity,
  HumidityToLocation
}
import java.util.stream.LongStream
import scala.jdk.FunctionConverters

/** Day 5: If You Give A Seed A Fertilizer
  *   - https://adventofcode.com/2023/day/5#part2
  */
object Part2 extends App {

  final case class Seeds(ranges: List[Long]) {

    def seeds: LongStream = ranges
      .grouped(2)
      .foldLeft(LongStream.empty()) {
        case (seeds, start :: length :: Nil) => LongStream.concat(seeds, LongStream.range(start, start + length))
        case (seeds, _)                      => seeds
      }
  }

  object Seeds {
    def apply: String => Seeds = { case s"seeds: $ranges" => Seeds(ranges.split(' ').flatMap(_.toLongOption).toList) }
  }

  final case class Converter(source: Long, target: Long, range: Long) {
    def convert(x: Long): Option[Long] = Option.when(x >= source && x < source + range)(target - source + x)
  }

  object Converter {
    def apply: String => Converter = { case s"$target $source $range" =>
      Converter(source.toLong, target.toLong, range.toLong)
    }
  }

  sealed trait Converters {
    def converters: List[Converter]

    def convert(x: Long): Long = converters
      .foldLeft(Option.empty[Long]) {
        case (None, converter) => converter.convert(x)
        case (y @ Some(_), _)  => y
      }
      .getOrElse(x)
  }

  object Converters {

    def apply: List[String] => Converters = {
      case "seed-to-soil map:" :: cs            => SeedToSoil(cs.map(Converter(_)))
      case "water-to-light map:" :: cs          => WaterToLight(cs.map(Converter(_)))
      case "soil-to-fertilizer map:" :: cs      => SoilToFertilizer(cs.map(Converter(_)))
      case "fertilizer-to-water map:" :: cs     => FertilizerToWater(cs.map(Converter(_)))
      case "light-to-temperature map:" :: cs    => LightToTemperature(cs.map(Converter(_)))
      case "humidity-to-location map:" :: cs    => HumidityToLocation(cs.map(Converter(_)))
      case "temperature-to-humidity map:" :: cs => TemperatureToHumidity(cs.map(Converter(_)))
      case _                                    => throw new IllegalArgumentException
    }

    final case class SeedToSoil(converters: List[Converter])            extends Converters
    final case class WaterToLight(converters: List[Converter])          extends Converters
    final case class SoilToFertilizer(converters: List[Converter])      extends Converters
    final case class FertilizerToWater(converters: List[Converter])     extends Converters
    final case class LightToTemperature(converters: List[Converter])    extends Converters
    final case class HumidityToLocation(converters: List[Converter])    extends Converters
    final case class TemperatureToHumidity(converters: List[Converter]) extends Converters
  }

  final case class Almanac(
      seedToSoil: SeedToSoil,
      soilToFertilizer: SoilToFertilizer,
      fertilizerToWater: FertilizerToWater,
      waterToLight: WaterToLight,
      lightToTemperature: LightToTemperature,
      temperatureToHumidity: TemperatureToHumidity,
      humidityToLocation: HumidityToLocation
  ) {

    def location(seed: Long): Long = {
      val soil        = seedToSoil.convert(seed)
      val fertilizer  = soilToFertilizer.convert(soil)
      val water       = fertilizerToWater.convert(fertilizer)
      val light       = waterToLight.convert(water)
      val temperature = lightToTemperature.convert(light)
      val humidity    = temperatureToHumidity.convert(temperature)
      val location    = humidityToLocation.convert(humidity)

      location
    }
  }

  object Almanac {

    def apply(input: List[String]): Almanac =
      input
        .mkString("\n")
        .split("\n\n")
        .toList
        .map(_.split("\n").filter(_.nonEmpty).toList)
        .map(Converters.apply(_)) match {
        case (s2s: SeedToSoil) :: (s2f: SoilToFertilizer) :: (f2w: FertilizerToWater) :: (w2l: WaterToLight) :: (l2t: LightToTemperature) :: (t2h: TemperatureToHumidity) :: (h2l: HumidityToLocation) :: Nil =>
          Almanac(s2s, s2f, f2w, w2l, l2t, t2h, h2l)
        case _                                                                                                                                                                                                =>
          throw new IllegalArgumentException
      }
  }

  val (seeds, almanac) = scala.io.Source.fromResource("year2023/day05/input.txt").getLines.toList match {
    case seeds :: converters => Seeds(seeds) -> Almanac(converters)
    case _                   => throw new IllegalArgumentException
  }

  val answer = seeds.seeds.parallel.map(seed => almanac.location(seed)).min

  println(answer)
}
