import sbt._
import Keys._

object Dependencies {
  val lift_json                 = "net.liftweb"                %% "lift-json"                 % "3.0-RC1"
  val scalafx                   = "org.scalafx"                %% "scalafx"                   % "8.0.60-R9"
  val jgit                      = "org.eclipse.jgit"           %  "org.eclipse.jgit"          % "4.2.0.201601211800-r"
  val typesafe_config           = "com.typesafe"               %  "config"                    % "1.3.0"
  val logback                   = "ch.qos.logback"             %  "logback-classic"           % "1.1.6"
  val logging                   = "com.typesafe.scala-logging" %% "scala-logging"             % "3.1.0"

  val scalatest                 = "org.scalatest"              %% "scalatest"                 % "2.2.6"
}
