buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
      maven("https://oss.sonatype.org/content/repositories/snapshots")
   }
}

plugins {
   kotlin("multiplatform").version("1.6.0")
   id("io.kotest.multiplatform") version "5.0.2"
}

repositories {
   mavenLocal()
   mavenCentral()
   maven("https://oss.sonatype.org/content/repositories/snapshots")
}

kotlin {
   targets {
      js(IR) {
         browser {
            testTask {
               useMocha()
            }
         }
         binaries.executable()
      }
   }
   sourceSets {
      val jsMain by getting {
         dependencies {
             implementation("io.ktor:ktor-client-js:1.6.7")
         }
      }
      val jsTest by getting {
         dependencies {
            implementation("io.kotest:kotest-assertions-core:5.0.1")
            implementation("io.kotest:kotest-framework-engine:5.0.1")
            implementation("io.kotest:kotest-framework-datatest:5.0.1")
            implementation("io.kotest:kotest-property:5.0.1")
         }
      }
   }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
   kotlinOptions {
      freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
   }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
   kotlinOptions {
      apiVersion = "1.6"
      verbose = true
   }
}
