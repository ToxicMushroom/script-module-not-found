plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "me.merlijn"
version = "1.0"

application {
    mainClass.set("MainKt")
}

repositories {
    mavenCentral()
}

val kotlinX = "1.6.4"
dependencies {
    // required for scriptDef.kt
    implementation(kotlin("scripting-common"))
    implementation(kotlin("scripting-jvm"))
    implementation(kotlin("scripting-dependencies"))
    implementation(kotlin("scripting-dependencies-maven"))

    // required for host.kt
    implementation(kotlin("scripting-jvm-host"))

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinX")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$kotlinX")
}

tasks {
    // from https://www.baeldung.com/kotlin/gradle-executable-jar
    val fatJar = register<Jar>("fatJar") {
        dependsOn.addAll(listOf("compileJava", "compileKotlin", "processResources")) // We need this for Gradle optimization to work
        archiveClassifier.set("standalone") // Naming the jar
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest { attributes(mapOf("Main-Class" to application.mainClass)) } // Provided we set it up in the application plugin configuration
        val sourcesMain = sourceSets.main.get()
        val contents = configurations.runtimeClasspath.get()
            .map { if (it.isDirectory) it else zipTree(it) } +
                sourcesMain.output
        from(contents)
    }
    build {
        dependsOn(fatJar) // Trigger fat jar creation during build
    }
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}