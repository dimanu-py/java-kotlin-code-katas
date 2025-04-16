plugins {
    kotlin("jvm")
}

group = "org.dimanu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":")) // If needed to depend on parent project
}

tasks.test {
    useJUnitPlatform()
    include("**/*Test.kt*", "**/*Should.kt*")
}