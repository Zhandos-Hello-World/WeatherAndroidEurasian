pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("kotlin", "1.8.10")
            version("coroutine", "1.7.1")
            version("androidGradlePlugin", "8.1.0")

            version("coreKtx", "1.10.1")
            version("appCompat", "1.6.1")
            version("coil", "2.4.0")
            version("serialization", "1.5.1")
            version("retrofit", "2.9.0")
            version("retrofitKotlinxSerialization", "1.0.0")
            version("loggingIntercepter", "4.11.0")
            version("koin", "3.4.0")
            version("lifecycle", "2.6.1")
            version("cicerone", "7.1")
            version("viewModelScope", "2.6.1")
            version("chucker", "3.5.2")

            plugin("android-application", "com.android.application").versionRef("androidGradlePlugin")
            plugin("android-library", "com.android.library").versionRef("androidGradlePlugin")
            plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
            plugin("kotlin-serailization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")

            library("coreKtx", "androidx.core", "core-ktx").versionRef("coreKtx")
            library("appCompat", "androidx.appcompat", "appcompat").versionRef("appCompat")

            library("androidMaterial", "com.google.android.material", "material").version("1.9.0")

            library("kotlinxCoroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutine")
            library("androidCoroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("coroutine")
            library("viewModelScope", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("viewModelScope")

            library("koltinxSerialization", "org.jetbrains.kotlinx", "kotlinx-serialization-core").versionRef("serialization")
            library("koitlinxJsonSerial", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef("serialization")

            library("retrofit", "com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            library("retrofitSerialization", "com.jakewharton.retrofit", "retrofit2-kotlinx-serialization-converter").versionRef("retrofitKotlinxSerialization")
            library("loggingInterceptor", "com.squareup.okhttp3", "logging-interceptor").versionRef("loggingIntercepter")

            library("koinCore", "io.insert-koin", "koin-core").versionRef("koin")
            library("koinAndroid", "io.insert-koin", "koin-android").versionRef("koin")

            library("cicerone", "com.github.terrakok", "cicerone").versionRef("cicerone")

            library("chuckerDebug", "com.github.chuckerteam.chucker", "library").versionRef("chucker")
            library("chuckerRelease", "com.github.chuckerteam.chucker", "library-no-op").versionRef("chucker")

            bundle("androidx", listOf("coreKtx", "appCompat"))
            bundle("serialization", listOf("koltinxSerialization", "koitlinxJsonSerial"))
            bundle("retrofit", listOf("retrofit", "retrofitSerialization", "loggingInterceptor"))
            bundle("di", listOf("koinCore", "koinAndroid"))
            bundle("coroutine", listOf("kotlinxCoroutines", "androidCoroutines"))
        }
    }
}

rootProject.name = "Weather Android"
include(":app")
include(":lib")
include(":lib:coreUI")
include(":lib:core")
include(":lib:coreData")
include(":lib:navigation")
include(":features")
include(":features:weather")
