name := "akka"

version := "1.0"

lazy val `akka` = (project in file(".")).enablePlugins(PlayScala)

val akkaVersion = "2.3.14"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  "org.scalikejdbc" %% "scalikejdbc" % "2.2.9",
  "org.scalikejdbc" %% "scalikejdbc-test" % "2.2.9" % "test",
  "mysql" % "mysql-connector-java" % "5.1.24",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.github.tototoshi" %% "play-flyway" % "1.2.0",
  "org.scalikejdbc" %% "scalikejdbc-config" % "2.2.9",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.4.2",
  "com.google.inject" % "guice" % "4.1.0",
  "net.codingwell" %% "scala-guice" % "4.1.0"
)

routesGenerator := InjectedRoutesGenerator

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )