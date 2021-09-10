plugins {
    kotlin("multiplatform") version "1.5.30"
    id("maven-publish")
    id("io.gitlab.arturbosch.detekt") version "1.18.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}

group = "org.chiachat"
version = "1.0.3"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://artifacts.consensys.net/public/maven/maven/")
}

val okioVersion = "3.0.0-alpha.9"
val ktorVersion = "1.6.3"
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    /*js(IR) {
        useCommonJs()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
    }*/
    /*
    iosArm64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    iosX64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }*/
    /*val publicationsFromMainHost =
        listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"

    publishing {
        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
            }
        }
    }*/
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("com.squareup.okio:okio-multiplatform:$okioVersion")
                implementation("io.ktor:ktor-client-websockets:$ktorVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("com.ionspin.kotlin:bignum:0.3.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("com.squareup.okio:okio:$okioVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("com.github.chiachat:jbls:1.0.5")
                implementation("org.apache.tuweni:tuweni-ssz:2.0.0")
                implementation("org.apache.tuweni:tuweni-bytes:2.0.0")
            }
        }
        val jvmTest by getting {
            dependencies {
                api("com.squareup.okio:okio-fakefilesystem:$okioVersion")
            }
        }
        /*val jsMain by getting {
            dependencies {
                api("com.squareup.okio:okio-nodefilesystem-js:$okioVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }*/
        /*
        val jsTest by getting
        val iosArm64Main by getting
        val iosArm64Test by getting
        val iosX64Main by getting
        val iosX64Test by getting*/
    }
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0")
}

//    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
//        debug.set(true)
//    }

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = true // activate all available (even unstable) rules.
    // point to your custom config defining rules to run, overwriting default behavior
    config = files("../config/detekt.yml")
    // a way of suppressing issues before introducing detekt
    baseline = file("../config/baseline.xml")

    reports {
        html.enabled = true // observe findings in your browser with structure and code snippets
        xml.enabled = true // checkstyle like format mainly for integrations like Jenkins
        txt.enabled = true
        // similar to the console output, contains issue signature to
        // manually edit baseline files
        sarif.enabled = true
        // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    // Target version of the generated JVM bytecode. It is used for type resolution.
    jvmTarget = "1.8"
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>()
        .versions.webpackDevServer.version = "4.0.0-rc.0"
}
