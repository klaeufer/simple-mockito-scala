name := "simple-mockito-scala"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test"
)