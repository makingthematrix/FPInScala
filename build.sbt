ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "FP_in_Scala",
    idePackagePrefix := Some("org.fpinscala")
  )

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.2"
