import Settings.{Versions => versions}
import Settings._

name := "chess-challenge"

scalaVersion := versions.scala

lazy val root = (project in file(".")).aggregate(domain)

lazy val domain = (project in file("domain")).settings(commonSettings: _*)