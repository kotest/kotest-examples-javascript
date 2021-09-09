buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
      maven("https://oss.sonatype.org/content/repositories/snapshots")
   }
}

plugins {
   kotlin("multiplatform").version("1.5.30")
   id("io.kotest.multiplatform") version "5.0.0.5"
}

repositories {
   mavenLocal()
   mavenCentral()
   maven("https://oss.sonatype.org/content/repositories/snapshots")
}

kotlin {
   targets {
      js(IR) {
         browser()
      }
   }
   sourceSets {
      val jsMain by getting {
         dependencies {
             implementation("io.ktor:ktor-client-js:1.6.1")
         }
      }
      val jsTest by getting {
         dependencies {
            implementation("io.kotest:kotest-assertions-core-js:5.0.0.476-SNAPSHOT")
            implementation("io.kotest:kotest-framework-engine-js:5.0.0.476-SNAPSHOT")
         }
      }
   }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
   kotlinOptions {
      apiVersion = "1.5"
      verbose = true
   }
}
