import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "me.m"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation("junit:junit:4.13")
    testImplementation("org.hamcrest:hamcrest:2.2")

    implementation("com.squareup:kotlinpoet:1.11.0")
    implementation("com.alibaba:easyexcel:3.0.5")

    implementation("com.github.matrixseven:ExcelReads:1.0.4")

}
tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}