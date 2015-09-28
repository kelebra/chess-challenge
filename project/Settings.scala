import sbt.Keys._
import sbt.ModuleID
import sbt._

object Settings {

  import Dependencies._

  lazy val commonSettings =
    Seq(
      organization := "com.tkachuko.chess",
      version := "0.1",
      scalaVersion := Versions.scala,
      sbtVersion := Versions.sbt,
      libraryDependencies ++= Seq(junit, scalaTest, scalaCheck)
    )

  object Versions {
    val scala = "2.11.7"
    val sbt = "0.13.7"
  }

  object Dependencies {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    val junit: ModuleID = "junit" % "junit" % "4.12" % "test"
    val scalaCheck: ModuleID = "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
  }

}