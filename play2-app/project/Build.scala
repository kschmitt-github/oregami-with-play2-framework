import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play2-app"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
//    javaEbean,
//    javaJpa,
    "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final",
//    "org.springframework" % "spring-context" % "3.2.0.RELEASE",
//    "org.springframework" % "spring-tx" % "3.2.0.RELEASE",
//    "org.springframework" % "spring-orm" % "3.2.0.RELEASE",
//    "org.springframework" % "spring-context-support" % "3.2.0.RELEASE",
//    "org.springframework.data" % "spring-data-jpa" % "1.2.0.RELEASE",
//    "org.springframework.data" % "spring-data-commons-core" % "1.4.0.RELEASE",
    "com.google.inject" % "guice" % "3.0",
    "com.google.inject.extensions" % "guice-persist" % "3.0"
            
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
