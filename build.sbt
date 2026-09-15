organization   := "competitive.programming"
version        := "0.1.0-SNAPSHOT"
scalaVersion   := scala2
publish / skip := true
scalacOptions ++= Seq("-release:25", "-deprecation", "-feature", "-unchecked")
javacOptions ++= Seq("--release", "25")
libraryDependencies ++= Seq(
  "org.scalameta" %% "munit"            % "1.3.6" % Test,
  "org.scalameta" %% "munit-scalacheck" % "1.3.1" % Test,
)
scalafmtConfig := (LocalRootProject / baseDirectory).value / ".scalafmt.conf"

Compile / packageBin / mainClass := None

lazy val scala2 = "2.13.18"
lazy val scala3 = "3.9.0"

lazy val root = project
  .in(file("."))
  .aggregate(
    adventofcode,
    atcoder,
    codeforces,
    csacademy,
    facebook,
    leetcodeScala2,
    leetcodeScala3,
    spoj,
    yandex,
  )
  .settings(name := "competitive-programming")

lazy val adventofcode   = project.in(file("adventofcode"))
lazy val atcoder        = project.in(file("atcoder"))
lazy val codeforces     = project.in(file("codeforces"))
lazy val csacademy      = project.in(file("csacademy"))
lazy val facebook       = project.in(file("facebook"))
lazy val spoj           = project.in(file("spoj"))
lazy val yandex         = project.in(file("yandex"))
lazy val leetcodeScala2 = project.in(file("leetcode/scala-2.13")).settings(scalaVersion := scala2)
lazy val leetcodeScala3 = project.in(file("leetcode/scala-3")).settings(scalaVersion := scala3)

addCommandAlias("verify", "testFull")
addCommandAlias("fmt", "scalafmtAll; scalafmtSbt")
addCommandAlias("fmtCheck", "scalafmtCheckAll; scalafmtSbtCheck")
