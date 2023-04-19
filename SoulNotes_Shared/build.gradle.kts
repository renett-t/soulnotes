plugins {
    kotlin("multiplatform")
    id("com.android.library")

    kotlin("plugin.serialization") version "1.8.20"
    id("com.squareup.sqldelight")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    // how to add dependencies on multiplatform project: https://kotlinlang.org/docs/multiplatform-add-dependencies.html
    sourceSets {
        val coroutinesVersion = "1.6.4"
        val ktorVersion = "2.2.4"
        val sqlDelightVersion = "1.5.5"
        val dateTimeVersion = "0.4.0"

        // shared configs
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")

//                implementation(libs.kotlinInject.runtime)
//                // todo: заимплементить libs и шаринг либ между модулями
                implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // android config
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")

                implementation("com.google.dagger:dagger-android:2.45")
            }
        }
        val androidUnitTest by getting

        // iOS config
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "dev.renett.soulnotes"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    // нахера тут андроид спрашивается
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.1")

    // KSP will eventually have better multiplatform support and we'll be able to simply have
    // `ksp libs.kotlinInject.compiler` in the dependencies block of each source set
    // https://github.com/google/ksp/pull/1021
//    add("kspIosX64", "me.tatarka.inject:kotlin-inject-compiler-ksp:1.8.10-1.0.9")
//    add("kspIosArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:1.8.10-1.0.9")
//    add("kspIosSimulatorArm64", "me.tatarka.inject:kotlin-inject-compiler-ksp:1.8.10-1.0.9")
}

sqldelight {
    database("SoulNotesDatabase") {
        packageName = "dev.renett.soulnotes.database"
        dialect = "sqlite:3.24"
    }
}
