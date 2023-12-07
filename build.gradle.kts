// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    //id("org.jetbrains.kotlin.android") version "1.9.0" apply false  // VN 20231207 This version (1.4.3) of the Compose Compiler requires Kotlin version 1.8.10 but you appear to be using Kotlin version 1.9.0 which is not known to be compatible.
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}