import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "me.m"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.hamcrest:hamcrest:2.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
    implementation("com.squareup:kotlinpoet:1.11.0")
    implementation("com.alibaba:easyexcel:3.0.5")
    implementation("com.github.matrixseven:ExcelReads:1.0.4")
    implementation(kotlin("reflect"))
//    implementation("org.jetbrains.kotlinx:kotlinx-reflect:1.6.3")


}
tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}