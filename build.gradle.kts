/*
 * Copyright (C) 2021 Adrian-Philipp Leuenberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.4.31"
    `maven-publish`
    signing
    id("org.jetbrains.dokka") version "1.4.30"
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.32"
val junitVersion = "5.7.0"
val mockkVersion = "1.11.0"

dependencies {
    api(kotlin("reflect"))
    api(kotlin("stdlib-jdk8"))
    api(group = "org.slf4j", name = "slf4j-api", version = slf4jVersion)

    testImplementation(group = "io.mockk", name = "mockk", version = mockkVersion)
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = junitVersion)

    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = junitVersion)
    testRuntimeOnly(group = "org.slf4j", name = "slf4j-simple", version = slf4jVersion)
}

group = "ch.leadrian.slf4k"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
        vendor.set(JvmVendorSpec.ADOPTOPENJDK)
    }

    withSourcesJar()
    withJavadocJar()
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            sourceCompatibility = "${JavaVersion.VERSION_1_8}"
            jvmTarget = "${JavaVersion.VERSION_1_8}"
        }
    }

    test {
        useJUnitPlatform()
    }

    named<Jar>("javadocJar") {
        from(dokkaHtml)
    }
}

val mavenJava by publishing.publications.creating(MavenPublication::class) {
    components.findByName("java")?.let { from(it) }
    pom {
        name.set("SLF4K")
        description.set("Kotlin extension functions for SLF4J")
        url.set("https://github.com/Double-O-Seven/slf4k")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("Double-O-Seven")
                name.set("Adrian-Philipp Leuenberger")
                email.set("thewishwithin@gmail.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/Double-O-Seven/slf4k.git")
            developerConnection.set("scm:git:ssh://github.com/Double-O-Seven/slf4k.git")
            url.set("https://github.com/Double-O-Seven/slf4k")
        }
    }
}

publishing {
    repositories {
        maven {
            val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
            val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            url = when {
                version.toString().endsWith("SNAPSHOT") -> snapshotsRepoUrl
                else -> releasesRepoUrl
            }
            credentials {
                val ossrhUsername: String? by extra
                val ossrhPassword: String? by extra
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}

signing {
    sign(mavenJava)
}
