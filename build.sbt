import Settings._
import sbt.Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import spray.revolver.RevolverPlugin.Revolver

name := "chess-challenge"

lazy val root = (project in file(".")).aggregate(domainJvm, domainJs, challenge, frontend, web)

lazy val domain = (crossProject.crossType(CrossType.Pure) in file("domain")).settings(commonSettings: _*)

lazy val domainJs = domain.js
lazy val domainJvm = domain.jvm

lazy val challenge = (project in file("challenge")).settings(commonSettings: _*).dependsOn(domainJvm)

lazy val frontend = (project in file("frontend"))
  .dependsOn(domainJs)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    commonSettings
      ++ Seq(
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.8.0",
        "com.lihaoyi" %%% "scalatags" % "0.4.5",
        "com.lihaoyi" %% "utest" % "0.3.1"
      ),
      testFrameworks += new TestFramework("utest.runner.Framework")
    ): _*)

lazy val web = (project in file("web"))
  .dependsOn(domainJvm, challenge)
  .settings(webSettings: _*)
  .settings(Revolver.settings: _*)
  .settings(
    (resourceGenerators in Compile) <+=
      (fastOptJS in Compile in frontend, packageScalaJSLauncher in Compile in frontend)
        .map((f1, f2) => Seq(f1.data, f2.data)),
    watchSources <++= (watchSources in frontend)
  )