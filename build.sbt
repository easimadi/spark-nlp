
// Dependency settings
val scalaLangVersion = "2.11.11"
val sparkVersion = "2.1.0"
val scalaTestVersion = "3.0.0"
val snowballVersion = "1.0"
val opennlpVersion = "1.6.0"
val scalanlpNERVersion = "2015.2.19"

lazy val analyticsDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.tartarus" % "snowball" % snowballVersion,
  "org.scalanlp" %% "epic-ner-en-conll" % scalanlpNERVersion exclude("com.typesafe.scala-logging", "scala-logging"),
  "org.apache.opennlp" % "opennlp-tools" % opennlpVersion
)

lazy val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion,
  "org.scalactic" %% "scalactic" % scalaTestVersion
)

lazy val utilDependencies = Seq(
  "com.typesafe" % "config" % "1.3.0"
)

lazy val logDependencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)

resolvers += "Collide repo" at "http://mvn.collide.info/content/repositories/releases/"

scalacOptions ++= Seq(
  // See other posts in the series for other helpful options
  "-feature",
  "-language:implicitConversions"
)

javaOptions in test += "-Xmx4G"
javaOptions in run += "-Xmx4G"
logBuffered in Test := false

// Module setup
lazy val root = (project in file("."))
  .settings(
    name := "sparknlp",
    version := "1.0.0",
    organization := "com.jsl.nlp",
    scalaVersion := scalaLangVersion,
    libraryDependencies ++=
      analyticsDependencies ++
      testDependencies ++
      utilDependencies ++
      logDependencies
  )


