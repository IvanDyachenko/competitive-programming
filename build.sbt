// scalafmt: { align.tokens.add = [ {code = ":=", owner = "Term.ApplyInfix"} ] }
ThisBuild / name         := "competitive-programming"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala2_13

lazy val root = (project in file("."))
  .aggregate(atcoder, codeforces, csacademy, facebook, spoj, yandex, leetcode, adventofcode)
  .settings(
    publish / skip     := true,
    scalafmtOnCompile  := true,
    crossScalaVersions := Nil
  )

lazy val atcoder = (project in file("atcoder"))
  .settings(
    crossScalaVersions := List(scala2_13),
    commonDependencies
  )

lazy val codeforces = (project in file("codeforces"))
  .settings(
    crossScalaVersions := List(scala2_12),
    commonDependencies
  )

lazy val csacademy = (project in file("csacademy"))
  .settings(
    crossScalaVersions := List(scala2_12),
    commonDependencies
  )

lazy val facebook = (project in file("facebook"))
  .settings(
    crossScalaVersions := List(scala2_13),
    commonDependencies
  )

lazy val spoj = (project in file("spoj"))
  .settings(
    crossScalaVersions := List(scala2_12),
    commonDependencies
  )

lazy val yandex = (project in file("yandex"))
  .settings(
    crossScalaVersions := List(scala2_13),
    commonDependencies
  )

lazy val leetcode = (project in file("leetcode"))
  .settings(
    crossScalaVersions := List(scala2_13),
    commonDependencies
  )

lazy val adventofcode = (project in file("adventofcode"))
  .settings(
    crossScalaVersions := List(scala2_13),
    commonDependencies
  )

lazy val commonDependencies =
  libraryDependencies ++= List(
    "org.scalameta" %% "munit"            % "0.7.29" % Test,
    "org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test
  )

lazy val scala2_12 = "2.12.15"
lazy val scala2_13 = "2.13.8"

lazy val scalacticVersion = "3.2.0"
lazy val scalatestVersion = "3.2.0"