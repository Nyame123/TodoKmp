package com.example.todo.model

data class TodoTask(
    val id: Long,
    val title: String,
    val isCompleted: Boolean = false,
)
