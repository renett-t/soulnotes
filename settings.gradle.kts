pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SoulNotes"
include(":SoulNotes")
include(":shared")
include(":SoulNotes:musictrack")
include(":SoulNotes:common")
include(":SoulNotes:common")
include(":SoulNotes:music")
include(":SoulNotes:player")
include(":shared:commonMain:music")
include(":shared:commonMain:podcasts")
