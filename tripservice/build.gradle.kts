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
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("io.mockk:mockk:1.13.5")
    }

    tasks.test {
        useJUnitPlatform()
        include("**/*Test.class*", "**/*Should.class*")
        testLogging { events("passed", "skipped", "failed") }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_22.toString()
        targetCompatibility = JavaVersion.VERSION_22.toString()
    }
}
