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
    "javax.mail" % "mail" % "1.4.6",
    "be.objectify" %% "deadbolt-java" % "2.1-SNAPSHOT",
    "net.sf.flexjson" % "flexjson" % "3.0"
    
    //,"mysql" % "mysql-connector-java" % "5.1.23"
            
            
            
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
      
	  resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
	  resolvers += Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns)
      
  )

}
