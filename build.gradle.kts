import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.2.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

val mindustryVersion = "v158"
val jabelVersion = "93fde537c7"

repositories {
    mavenCentral()
    maven { url = uri("https://www.jitpack.io") }
    ivy {
        url = uri("https://github.com/")
        metadataSources { artifact() }
        patternLayout {
            artifact("/[organisation]/[module]/releases/download/[revision]/[artifact].jar")
        }
    }
}

dependencies {
    compileOnly("Anuken:Mindustry:$mindustryVersion:dependencies")
    annotationProcessor("com.github.Anuken:jabel:$jabelVersion")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    compileOnly("org.jetbrains:annotations:26.0.1")

    implementation("org.codejargon.feather:feather:1.0")
    implementation("javax.inject:javax.inject:1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")
}

val mindustryRuntime = configurations.create("mindustryRuntime")

dependencies {
    add("mindustryRuntime", "Anuken:Mindustry:$mindustryVersion")
}

tasks.named<ShadowJar>("shadowJar") {
    archiveFileName.set("${rootProject.name}-desktop.jar")
}

val shadowJar = tasks.named<ShadowJar>("shadowJar")

tasks.register("jarAndroid") {
    description = "Build android jar"
    dependsOn("shadowJar")

    doLast {
        val androidHome = System.getenv("ANDROID_HOME") ?: System.getenv("ANDROID_SDK_ROOT")
        if (androidHome.isNullOrBlank() || !File(androidHome).exists()) {
            throw GradleException("No valid Android SDK found. Set ANDROID_HOME.")
        }

        val platformRoot = File(androidHome, "platforms")
            .listFiles()
            ?.sorted()
            ?.reversed()
            ?.firstOrNull { f -> File(f, "android.jar").exists() }
            ?: throw GradleException("No android.jar found in SDK platforms.")

        val buildToolsDir = File(androidHome, "build-tools")
        val latestBuildTools = buildToolsDir.listFiles()
            ?.sorted()
            ?.reversed()
            ?.firstOrNull()
            ?: throw GradleException("No build-tools found in Android SDK.")

        val isWindows = System.getProperty("os.name").lowercase().contains("windows")
        val d8Name = if (isWindows) "d8.bat" else "d8"
        val d8File = File(latestBuildTools, d8Name)

        if (!d8File.exists()) {
            throw GradleException("d8 tool not found at: ${d8File.absolutePath}")
        }

        val libsDir = file("build/libs")
        val classpath = (configurations.compileClasspath.get().files
                + configurations.runtimeClasspath.get().files
                + File(platformRoot, "android.jar"))
            .joinToString(" ") { "--classpath ${it.absolutePath}" }

        val process = ProcessBuilder(d8File.absolutePath, *classpath.split(" ").toTypedArray(),
            "--min-api", "26",
            "--output", "${rootProject.name}-android.jar",
            "${rootProject.name}-desktop.jar")
            .directory(libsDir)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()

        if (process.waitFor() != 0) {
            throw GradleException("d8 failed")
        }
    }
}

tasks.register<Jar>("deploy") {
    description = "Build cross-platform artifact"
    dependsOn("jarAndroid", "shadowJar")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    destinationDirectory.set(file("build/libs"))
    archiveFileName.set("${rootProject.name}.jar")

    from(provider {
        listOf(
            zipTree(file("build/libs/${rootProject.name}-desktop.jar")),
            zipTree(file("build/libs/${rootProject.name}-android.jar"))
        )
    })

    doLast {
        file("build/libs/${rootProject.name}-desktop.jar").delete()
        file("build/libs/${rootProject.name}-android.jar").delete()
    }
}

tasks.register<JavaExec>("runGame") {
    description = "Build mod, install to Mindustry mods, and launch game"
    dependsOn(shadowJar)

    doFirst {
        val modsDir = file(System.getenv("APPDATA") + "/Mindustry/mods")
        modsDir.mkdirs()
        copy {
            from(shadowJar.get().archiveFile)
            into(modsDir)
        }
        println("Copied mod to " + modsDir.resolve("${rootProject.name}-desktop.jar"))
    }

    standardInput = System.`in`
    workingDir = file("${rootProject.projectDir}")
    classpath = mindustryRuntime
    mainClass.set("mindustry.desktop.DesktopLauncher")
}
