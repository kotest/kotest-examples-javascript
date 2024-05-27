plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest.multiplatform)
}

repositories {
   mavenLocal()
   mavenCentral()
   maven("https://oss.sonatype.org/content/repositories/snapshots")
}

kotlin {
   js(IR) {
      nodejs()
   }
   sourceSets {
      val jsMain by getting {
         dependencies {
            implementation(libs.ktor.client.js)
         }
      }
      val jsTest by getting {
         dependencies {
            implementation(libs.kotest.assertions.core)
            implementation(libs.kotest.framework.engine)
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
      apiVersion = "1.9"
      verbose = true
   }
}
