plugins {
    kotlin("jvm") version "1.9.20"
    application
    id("io.qameta.allure") version "2.11.2"
    id("com.adarshr.test-logger") version "4.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
    id("org.jlleitschuh.gradle.ktlint") version "12.0.2"
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

    // подключение алюра
    implementation("io.qameta.allure:allure-junit-platform:2.25.0")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    agent("org.aspectj:aspectjweaver:1.9.20.1")

    // подключение котеста
    testImplementation("io.kotest:kotest-runner-junit5:5.6.0")
    testImplementation("io.kotest:kotest-assertions-core:5.6.0")
    testImplementation("io.kotest:kotest-property:5.6.0")

    // подключение кукумбера
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.platform:junit-platform-suite:1.8.1")
    testImplementation("io.cucumber:cucumber-java8:7.14.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.1")
    // подключение алюра к кукумберу
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:2.25.0")
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

    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}