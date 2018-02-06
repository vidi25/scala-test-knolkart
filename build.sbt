import Dependencies._

name := "scalatest-knolkart"

version := "0.1"

scalaVersion := "2.12.4"

coverageEnabled := true

lazy val root = (project in file(".")) aggregate(accounts, inventory, checkout, apiResources, dashboard)

lazy val accounts = (project in file("accounts"))
  .settings(
    libraryDependencies ++= Seq(testDeps,loggerDeps)
  )

lazy val inventory = (project in file("inventory"))
  .settings(
    libraryDependencies ++= Seq(testDeps,loggerDeps)
  )

lazy val apiResources = (project in file("apiResources"))
    .dependsOn(accounts,inventory,checkout)
  .settings(
    libraryDependencies ++= Seq(testDeps,loggerDeps)
  )

lazy val checkout = (project in file("checkout"))
      .dependsOn(inventory,accounts)
    .settings(
    libraryDependencies ++= Seq(testDeps,loggerDeps)
  )

lazy val dashboard = (project in file("dashboard"))
    .dependsOn(apiResources)
  .settings(
    libraryDependencies ++= Seq(testDeps,loggerDeps)
  )