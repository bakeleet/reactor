plugins {
    id("java")
    checkstyle
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)

    implementation(platform(libs.reactor.bom))
    implementation(libs.reactor.core)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.engine)
}

application {
    mainClass.set("org.example.Main")
}

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = file("${rootDir}/config/checkstyle/checkstyle.xml")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
