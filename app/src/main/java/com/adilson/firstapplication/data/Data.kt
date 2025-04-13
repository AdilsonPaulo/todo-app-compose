package com.adilson.firstapplication.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.adilson.firstapplication.domain.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateOf<List<Task>>(emptyList())
    val tasks: List<Task> get() = _tasks.value

    fun toggleTaskStatus(task: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == task.id) {
                it.copy(isFinished = !it.isFinished)
            } else {
                it
            }
        }
    }

    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
    }

    fun deleteTask(task: Task) {
        _tasks.value = _tasks.value.filter { it.id != task.id }
    }
}
