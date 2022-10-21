rootProject.name = "reactor"

include(":app")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("checkstyle", "8.37")
            version("reactor", "2020.0.24")
            version("junit", "5.9.0")
            version("lombok", "1.18.24")

            library("lombok", "org.projectlombok", "lombok").versionRef("lombok")
            library("reactor-bom", "io.projectreactor", "reactor-bom").versionRef("reactor")
            library("reactor-core", "io.projectreactor", "reactor-core").withoutVersion()
            library("junit-jupiter","org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit-engine","org.junit.jupiter", "junit-jupiter-engine").withoutVersion()
        }
    }
}
