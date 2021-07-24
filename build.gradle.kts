
plugins {
    `java-library`
    kotlin("jvm")
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
	api(group = "org.slf4j", name = "slf4j-api", version = "1.7.32")
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
                else                                    -> releasesRepoUrl
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
