plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

val versionSource = rootProject.file("builtsrc/version.kt").readText()

fun readVersionConstant(name: String): String {
    val prefix = "const val " + name + " = "
    return versionSource.lineSequence()
        .firstOrNull { it.trim().startsWith(prefix) }
        ?.trim()
        ?.removePrefix(prefix)
        ?.trim()
        ?.trim('"')
        ?: error("Missing KirinBok version constant: " + name)
}

val appVersionName = readVersionConstant("NAME")
val appVersionCode = readVersionConstant("CODE").toInt()
val appVersionChannel = readVersionConstant("CHANNEL")

android {
    namespace = "app.kirinbok"
    compileSdk = 36

    defaultConfig {
        applicationId = "app.kirinbok"
        minSdk = 26
        targetSdk = 36
        versionCode = appVersionCode
        versionName = appVersionName
        buildConfigField(
            "String",
            "APP_CHANNEL",
            34.toChar().toString() + appVersionChannel + 34.toChar().toString(),
        )
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2026.02.00"))
    implementation("androidx.activity:activity-compose:1.13.0")
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.10.0")

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    debugImplementation("androidx.compose.ui:ui-tooling")
}
