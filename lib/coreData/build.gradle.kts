plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
}

android {
    namespace = "kz.zhandos.lib.core.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        buildConfigField("String", "BASE_URL", "\"https://api.openweathermap.org\"")
        buildConfigField("String", "API_KEY", "\"e6aa2b8805ea7395b9835bc2b7a6f9ab\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(path = ":lib:core"))

    implementation(libs.bundles.serialization)
    implementation(libs.bundles.coroutine)
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.di)

    debugImplementation(libs.chuckerDebug)
    releaseImplementation(libs.chuckerRelease)
}