plugins {
    id("java-library")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
    alias(libs.plugins.jetbrains.kotlin.jvm)
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi)
    ksp(libs.moshi.ksp)
    testImplementation(libs.junit)
}