ThisBuild / name := "competitive-programming"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala2_13

lazy val root = (project in file("."))
  .aggregate(atcoder, codeforces)
  .settings(
    publish / skip := true,
    scalafmtOnCompile := true,
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

lazy val commonDependencies =
  libraryDependencies ++= List(
    "org.scalactic" %% "scalactic" % scalacticVersion % "test",
    "org.scalatest" %% "scalatest" % scalatestVersion % "test",
    "org.scalatest" %% "scalatest-flatspec" % scalatestVersion % "test"
  )

lazy val scala2_12 = "2.12.8"
lazy val scala2_13 = "2.13.1"

lazy val scalacticVersion = "3.2.0"
lazy val scalatestVersion = "3.2.0"
