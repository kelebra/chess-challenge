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

  lazy val webSettings = commonSettings ++ Seq(
    libraryDependencies ++= Seq(akkaHTTP)
  )

  object Versions {
    val scala = "2.11.7"
    val sbt = "0.13.7"
    val akkaHttp = "1.0-M5"
  }

  object Dependencies {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    val junit: ModuleID = "junit" % "junit" % "4.12" % "test"
    val scalaCheck: ModuleID = "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

    val akkaHTTP: ModuleID = "com.typesafe.akka" %% "akka-http-experimental" % Versions.akkaHttp
  }

}