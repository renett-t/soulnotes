plugins {
    id("com.android.application")
    kotlin("android")

    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
    namespace = "dev.renett.soulnotes.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "dev.renett.soulnotes.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":SoulNotes_Shared"))
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.ui:ui-tooling:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.material:material:1.4.0")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.core:core-ktx:1.10.0")

    ksp("me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.1")
    implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.1")
}