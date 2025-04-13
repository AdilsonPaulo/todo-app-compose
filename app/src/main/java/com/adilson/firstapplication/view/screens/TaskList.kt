package com.adilson.firstapplication.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adilson.firstapplication.data.TaskViewModel
import com.adilson.firstapplication.view.ui_components.TaskCard

@SuppressLint("NewApi")
@Composable
fun TaskList(taskViewModel: TaskViewModel, modifier: Modifier = Modifier) {
    val (toDoTasks, finishedTasks) = taskViewModel.tasks.partition { !it.isFinished }

    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (toDoTasks.isNotEmpty()) {
            item {
                Text(
                    text = "My Tasks",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            items(toDoTasks) { task ->
                TaskCard(
                    task,
                    onToggleFinished = { taskViewModel.toggleTaskStatus(it) },
                    onDeleteTask = { taskViewModel.deleteTask(it)})
            }
        }

        if (finishedTasks.isNotEmpty()) {
            item {
                Text(
                    text = "Finished",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            items(finishedTasks) { task ->
                TaskCard(
                    task,
                    onToggleFinished = { taskViewModel.toggleTaskStatus(it) },
                        onDeleteTask = { taskViewModel.deleteTask(it)}) }
            }
        }
    }


