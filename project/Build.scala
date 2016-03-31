import sbt._
import sbt.Keys._

import Dependencies._

object Build extends Build {
  lazy val root = Project("delta-v", file("."))
    .settings(
      mainClass := Some("net.team2xh.deltav.Main"),
      libraryDependencies in Compile ++= Seq(
        lift_json
      ),
      libraryDependencies in Test ++= Seq(
        scalatest
      )
    )
}
