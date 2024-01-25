plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

android {
    namespace = "kz.zhandos.features.weather"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(path = ":lib:core"))
    implementation(project(path = ":lib:coreUI"))
    implementation(project(path = ":lib:coreData"))
    implementation(project(path = ":lib:navigation"))

    implementation(libs.bundles.androidx)
    implementation(libs.androidMaterial)
    implementation(libs.viewModelScope)
    implementation(libs.bundles.di)
    implementation(libs.bundles.retrofit)
    implementation(libs.cicerone)
    implementation(libs.bundles.serialization)
}