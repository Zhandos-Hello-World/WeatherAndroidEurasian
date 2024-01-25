plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "kz.zhandos.lib.coreui"
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

    implementation(libs.bundles.androidx)
    implementation(libs.androidMaterial)
    implementation(libs.viewModelScope)
    implementation(libs.bundles.di)
    implementation(libs.cicerone)
}