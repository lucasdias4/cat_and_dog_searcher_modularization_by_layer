import com.lucasdias.buildSrc.Dependency

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(Dependency.Module.android_core))
    implementation(project(Dependency.Module.domain))
    implementation(project(Dependency.Module.presentation_common_model))
    implementation(Dependency.Core.appcompat)
    implementation(Dependency.Core.coroutines_core)
    implementation(Dependency.Core.core_ktx)
    implementation(Dependency.Core.lifecycle_view_model)
    implementation(Dependency.DI.koin)
    testImplementation(Dependency.Test.junit)
    testImplementation(Dependency.Test.kotlinx_coroutines_test)
    testImplementation(Dependency.Test.mockk)
}