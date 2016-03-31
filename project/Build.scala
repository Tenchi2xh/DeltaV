import sbt._
import sbt.Keys._

import Dependencies._

object Build extends Build {
  lazy val root = Project("delta-v", file("."))
    .settings(
      organization := "net.team2xh",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := "2.11.7",

      mainClass := Some("net.team2xh.deltav.Main"),

      javaOptions += "-Xdock:name=\"DeltaV\"",

      fork in Runtime := true,
      fork in Test := true,

      libraryDependencies ++= Seq(
        lift_json,
        scalafx,
        jgit
      ),
      libraryDependencies in Test ++= Seq(
        scalatest
      )
    )
}
