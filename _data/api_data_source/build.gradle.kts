import com.lucasdias.buildSrc.Dependency

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
    implementation(project(Dependency.Module.api))
    implementation(project(Dependency.Module.api_model))
    implementation(project(Dependency.Module.data_core))
    implementation(project(Dependency.Module.repository))
    implementation(Dependency.Core.core_ktx)
    implementation(Dependency.Core.appcompat)
    implementation(Dependency.Data.retrofit)
    implementation(Dependency.Data.logging_interceptor)
    implementation(Dependency.DI.koin)
    testImplementation(Dependency.Test.junit)
    testImplementation(Dependency.Test.kotlinx_coroutines_test)
    testImplementation(Dependency.Test.mockk)
    testImplementation(Dependency.Test.mockito_inline)
}