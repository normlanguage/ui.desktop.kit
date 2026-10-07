plugins {
    `java-library`
    `maven-publish`
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "dev.normlanguage"
version = "2"

repositories { mavenCentral() }

java { toolchain { languageVersion = JavaLanguageVersion.of(25) } }
providers.gradleProperty("testSource").orNull?.let { selected ->
    sourceSets.test { java { include("**/FxTest.java"); selected.split(",").forEach { include("**/$it.java") } } }
}

javafx {
    version = "25.0.2"
    modules("javafx.base", "javafx.graphics", "javafx.controls")
    configuration = "api"
}

dependencies {
    implementation("com.google.zxing:core:3.5.3")
    api("org.kordamp.ikonli:ikonli-javafx:12.4.0")
    runtimeOnly("org.kordamp.ikonli:ikonli-materialdesign2-pack:12.4.0")
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
val gallery = sourceSets.create("gallery") {
    java.srcDir("samples/gallery/java")
    resources.srcDir("samples/gallery/resources")
    compileClasspath += sourceSets.main.get().output + configurations.runtimeClasspath.get()
    runtimeClasspath += output + compileClasspath
}
sourceSets.test { compileClasspath += gallery.output; runtimeClasspath += gallery.output }
val galleryJar = tasks.register<Jar>("galleryJar") {
    archiveBaseName.set("ui-fx-gallery")
    archiveVersion.set("1")
    includeEmptyDirs = false
    from(gallery.output)
    from("samples/gallery") { include("**/*.norm"); exclude("tests/**", "module.norm"); into("norm-source/samples/gallery") }
    from("ui/fx/kit") { include("**/*.norm"); exclude("module.norm"); exclude("tests/**"); into("norm-source/ui/fx/kit") }
    val uiRoot = providers.gradleProperty("uiRoot").orElse("")
    doFirst {
        require(uiRoot.get().isNotBlank()) { "galleryJar requires -PuiRoot=<ui source repository>" }
        for (source in listOf("layouts.norm", "elements.norm")) {
            require(file("${uiRoot.get()}/ui/$source").isFile) { "Missing gallery source: ${uiRoot.get()}/ui/$source" }
        }
    }
    from(uiRoot.map { "$it/ui" }) { include("layouts.norm", "elements.norm"); into("norm-source/ui") }
}
tasks.withType<Jar>().configureEach { from("LICENSE") { into("META-INF") } }
val generateThemeFixtures = tasks.register<Exec>("generateThemeFixtures") {
    workingDir(projectDir)
    val norm = providers.environmentVariable("NORM_EXECUTABLE").orElse("norm")
    commandLine(norm.get(), "run", "samples/fixtures")
    providers.gradleProperty("normHome").orNull?.let { home ->
        environment("JAVA_TOOL_OPTIONS", System.getenv("JAVA_TOOL_OPTIONS").orEmpty() + " -Duser.home=\"$home\"")
    }
}
tasks.withType<Test>().configureEach {
    if (!providers.gradleProperty("skipThemeFixtures").isPresent) { dependsOn(generateThemeFixtures) }

    useJUnitPlatform()
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    testLogging { events("passed", "skipped", "failed") }
}

tasks.register<Test>("themeRenderingTest") {
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    useJUnitPlatform { includeTags("theme-rendering") }
}
tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
publishing {
    publications {
        create<MavenPublication>("library") { from(components["java"]) }
        create<MavenPublication>("gallery") {
            artifactId = "ui-fx-gallery"
            version = "1"
            artifact(galleryJar)
            pom.withXml {
                val dependency = asNode().appendNode("dependencies").appendNode("dependency")
                dependency.appendNode("groupId", project.group)
                dependency.appendNode("artifactId", "ui-fx-kit")
                dependency.appendNode("version", project.version)
            }
        }
    }
    repositories { maven { url = uri(layout.buildDirectory.dir("repository")) } }
}
tasks.register<Copy>("normDependencies") {
    from(configurations.runtimeClasspath)
    into(layout.buildDirectory.dir("norm-dependencies"))
}
