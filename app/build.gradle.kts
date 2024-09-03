plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.movieappwithtestingng"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieappwithtestingng"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose and UI dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.runtime.compose.android)

    // Coil Image Loading Library
    implementation(libs.coil)

    // Serialization Libraries
    implementation(libs.serialization)

    // Networking dependencies
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // ViewModel dependencies
    implementation(libs.lifecycle.viewmodel.compose)

    // Dependency Injection (Hilt)
    implementation(libs.hiltAndroid)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hiltCompiler)

    // Navigation Compose
    implementation(libs.navigation.compose)

    // Testing dependencies
    testImplementation(libs.junit)
    testImplementation(libs.coroutinesTest)
    testImplementation(libs.mockk)

    // Android Testing dependencies
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.composeUiTest)
    androidTestImplementation(libs.mockkAndroid)
    androidTestImplementation(libs.mockWebServer)
    androidTestImplementation(libs.hilt.android.testing)

    // Debugging dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.composeUiTestManifest)
}
