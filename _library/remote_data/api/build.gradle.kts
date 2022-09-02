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
            buildConfigField ("String", "CAT_API_URL", "\"https://api.thecatapi.com/\"")
            buildConfigField ("String", "DOG_API_URL", "\"https://api.thedogapi.com/\"")
            buildConfigField ("String", "CAT_API_KEY", "\"b1cc6a99-aed5-43a4-8ac0-838b022ed7b7\"")
            buildConfigField ("String", "DOG_API_KEY", "\"a3ee1cc2-3bb9-4a50-bbd9-1bffbf9b3494\"")
            buildConfigField ("String", "CAT_IMAGE_URL", "\"https://cdn2.thecatapi.com/images/\"")
            buildConfigField ("String", "DOG_IMAGE_URL", "\"https://cdn2.thedogapi.com/images/\"")
        }
        debug {
            buildConfigField ("String", "CAT_API_URL", "\"https://api.thecatapi.com/\"")
            buildConfigField ("String", "DOG_API_URL", "\"https://api.thedogapi.com/\"")
            buildConfigField ("String", "CAT_API_KEY", "\"b1cc6a99-aed5-43a4-8ac0-838b022ed7b7\"")
            buildConfigField ("String", "DOG_API_KEY", "\"a3ee1cc2-3bb9-4a50-bbd9-1bffbf9b3494\"")
            buildConfigField ("String", "CAT_IMAGE_URL", "\"https://cdn2.thecatapi.com/images/\"")
            buildConfigField ("String", "DOG_IMAGE_URL", "\"https://cdn2.thedogapi.com/images/\"")        }
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
    implementation(project(Dependency.Module.api_model))
    implementation(Dependency.Data.converter_gson)
    implementation(Dependency.Data.logging_interceptor)
    implementation(Dependency.Data.retrofit)
}