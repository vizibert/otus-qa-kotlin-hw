plugins {
    kotlin("jvm") version "1.9.20"
    application
    id("io.qameta.allure") version "2.11.2"
    id("com.adarshr.test-logger") version "4.0.0"
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

testlogger {
    showPassed = true
}

val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.20")
    implementation("io.github.serpro69:kotlin-faker:1.15.0")
    implementation("io.qameta.allure:allure-junit-platform:2.24.0")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    agent("org.aspectj:aspectjweaver:1.9.20.1")
}

application {
    mainClass.set("MainKt")
}

tasks {

    test {
        jvmArgs = listOf("-javaagent:${agent.singleFile}")
        useJUnitPlatform()
    }

    getByName<Test>("test") {
        useJUnitPlatform()
        finalizedBy("jacocoTestReport", "allureReport")
    }

    register("test-smoke", Test::class) {
        useJUnitPlatform {
            setTestNameIncludePatterns(listOf("lesson_04_gradle.smoke.*"))
        }
    }

    register("test-smoke-positive", Test::class) {
        useJUnitPlatform {
            setTestNameIncludePatterns(listOf("lesson_04_gradle.smoke.*"))
            includeTags("positive")
        }
    }
}

