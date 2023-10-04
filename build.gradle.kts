// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.com.android.library) apply false
}

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
//        classpath(libs.android.gradle.plugin)
//        classpath(libs.secrets.gradle.plugin)
    }
}