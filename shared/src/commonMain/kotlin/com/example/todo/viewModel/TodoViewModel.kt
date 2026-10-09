package com.example.todo.viewModel

import com.example.todo.model.TodoTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel {
    private val _tasks = MutableStateFlow<List<TodoTask>>(emptyList())
    val tasks: StateFlow<List<TodoTask>> = _tasks.asStateFlow()

    private var nextId = 1L

    fun addTask(title: String) {
        if (title.isBlank()) return
        _tasks.update { currentList ->
            currentList + TodoTask(id = nextId++, title = title)
        }
    }

    fun toggleTaskCompletion(taskId: Long) {
        _tasks.update { currentList ->
            currentList.map { task ->
                if (task.id == taskId) task.copy(isCompleted = !task.isCompleted) else task
            }
        }
    }

    fun deleteTask(taskId: Long) {
        _tasks.update { currentList ->
            currentList.filter { it.id != taskId }
        }
    }
}
