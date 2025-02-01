plugins {
    java
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "org.dimanu"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation("io.rest-assured:rest-assured")
        testImplementation("io.rest-assured:rest-assured-common")
        testImplementation("io.rest-assured:json-path")
        testImplementation("io.rest-assured:xml-path")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

