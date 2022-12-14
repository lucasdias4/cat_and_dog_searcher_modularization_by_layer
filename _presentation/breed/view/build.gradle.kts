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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Dependency.Module.android_core))
    implementation(project(Dependency.Module.breed_view_model))
    implementation(project(Dependency.Module.presentation_common_model))
    implementation(project(Dependency.Module.resource))
    implementation(Dependency.Core.core_ktx)
    implementation(Dependency.Core.appcompat)
    implementation(Dependency.DI.koin)
    implementation(Dependency.UI.constraint_layout)
    implementation(Dependency.UI.material)
    implementation(Dependency.UI.shimmer)
}