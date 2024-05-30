import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.plugin)
    alias(libs.plugins.compose.compiler)
}

group = "com.breadmoirai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation(libs.compose.material)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.contentNegotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.websockets)
    implementation(libs.ktor.serialization)
    implementation(libs.kotlin.serialization)
    implementation(libs.kstore.core)
    implementation(libs.kstore.file)
}

compose.desktop {
    application {
        mainClass = "com.breadmoirai.tabletoplabs.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "tabletoplabs"
            packageVersion = "1.0.0"
        }
    }
}

fun DependencyHandlerScope.kstore() {
    sourceSets {
//        val commonMain by getting {
        dependencies {
            implementation("io.github.xxfast:kstore:0.8.0")
        }
//        }
//
//        val androidMain by getting {
//            dependencies {
//                implementation("io.github.xxfast:kstore-file:0.8.0")
//            }
//        }
//
//        val iosMain by getting {
//            dependencies {
//                implementation("io.github.xxfast:kstore-file:0.8.0")
//            }
//        }
//
//        val jvmMain by getting {
        dependencies {
            implementation("io.github.xxfast:kstore-file:0.8.0")
        }
//        }
//
//        val jsMain by getting {
//            dependencies {
//                implementation("io.github.xxfast:kstore-storage:0.8.0")
//            }
//        }
    }
}