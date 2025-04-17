plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.dimanu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


allprojects {
    apply(plugin = "kotlin")

    dependencies {
        testImplementation("org.jetbrains.kotlin:kotlin-test")
    }

    tasks.test {
        useJUnitPlatform()
        include("**/*Test.class*", "**/*Should.class*")
        testLogging { events("passed", "skipped", "failed") }
    }
}

kotlin {
    jvmToolchain(17)
}
