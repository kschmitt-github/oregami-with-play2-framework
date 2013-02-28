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
    "com.google.inject" % "guice" % "3.0",
    "com.google.inject.extensions" % "guice-persist" % "3.0",
    "org.jasypt" % "jasypt" % "1.9.0",
    "javax.mail" % "mail" % "1.4.6"
            
            
            
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
