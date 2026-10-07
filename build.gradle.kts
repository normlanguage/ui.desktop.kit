plugins {
    `java-library`
    `maven-publish`
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "dev.normlanguage"
version = "1"

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
tasks.processResources {
    from(providers.gradleProperty("uiRoot").orElse("../ui").map { "$it/ui" }) { include("layouts.norm", "elements.norm"); into("norm-source/ui") }
    from("samples/gallery") { include("**/*.norm"); exclude("tests/**"); into("norm-source/samples/gallery") }
    from("ui/fx/kit") { include("*.norm"); exclude("module.norm"); into("norm-source/ui/fx/kit") }
}
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    testLogging { events("passed", "skipped", "failed") }
}

tasks.named<Test>("test") {
    useJUnitPlatform {
        if (!providers.gradleProperty("testSource").isPresent) {
            excludeTags("theme-rendering")
        }
    }
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
    publications { create<MavenPublication>("library") { from(components["java"]) } }
    repositories { maven { url = uri(layout.buildDirectory.dir("repository")) } }
}
tasks.register<Copy>("normDependencies") {
    from(configurations.runtimeClasspath)
    into(layout.buildDirectory.dir("norm-dependencies"))
}
