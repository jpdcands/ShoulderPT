buildscript {
    val agpVersion by extra("8.2.2")
    val agpVersion1 by extra("8.2.2")
    val agpVersion2 by extra("8.3.0")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
}