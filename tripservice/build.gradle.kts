plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.dimanu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "kotlin")

    dependencies {
        testImplementation(kotlin("test"))
    }

    tasks.test {
        useJUnitPlatform()
        include("**/*Test.kt*", "**/*Should.kt*")
    }
}
