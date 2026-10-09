package com.example.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform