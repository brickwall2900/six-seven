plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("net.thebugmc.gradle.sonatype-central-portal-publisher").version("1.2.4")
}

group = "io.github.brickwall2900"
version = "6.7.1"
description = "six seven"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
    withJavadocJar()
}

signing {
    useGpgCmd()
}

centralPortal {
    pom {
        name = project.group.toString()
        description = project.description
        inceptionYear = "2026"
        url = "https://codeberg.org/brickwall2900/six-seven"

        licenses {
            license {
                name = "MIT License"
                url = "https://mit-license.org/"
            }
        }

        developers {
            developer {
                id = "brickwall2900"
                name = "Marsh"
                email = "brickwall2900@gmail.com"
            }
        }

        scm {
            connection = "scm:https://codeberg.org/brickwall2900/six-seven.git"
            developerConnection = "scm:git:ssh://git@codeberg.org/brickwall2900/six-seven.git"
            url = "https://codeberg.org/brickwall2900/six-seven"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}