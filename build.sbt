name := "Sprak-Cassandra-Scala-Play"

version := "1.0"

lazy val `sprak-cassandra-scala-play` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

val sparkVersion = "1.6.2"

val cassandraVersion = "1.6.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "com.datastax.spark" %% "spark-cassandra-connector" % cassandraVersion,
  specs2 % Test
)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4" //to resolve version conflicts with play
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  