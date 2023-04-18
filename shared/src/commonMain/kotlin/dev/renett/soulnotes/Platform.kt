package dev.renett.soulnotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform