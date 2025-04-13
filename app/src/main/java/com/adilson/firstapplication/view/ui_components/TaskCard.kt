package com.adilson.firstapplication.view.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adilson.firstapplication.domain.model.Task
import com.adilson.firstapplication.ui.theme.Red
import com.adilson.firstapplication.utils.formatToString
import java.time.LocalDate

@SuppressLint("NewApi")
@Composable
fun TaskCard(task: Task, onToggleFinished: (Task) -> Unit, onDeleteTask: (Task) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    fun confirmDelete() {
        showDialog = true
    }

    fun Deletion() {
        onDeleteTask(task)
        showDialog = false
    }

    fun cancelDeletion() {
        showDialog = false
    }

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                RoundedCheckBox(
                    checked = task.isFinished,
                    onCheckedChange = {
                        onToggleFinished(task.copy(isFinished = it))
                    }
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = task.title, style = MaterialTheme.typography.titleMedium)
                    task.endDate?.let {
                        val currentDate = LocalDate.now()
                        if (it.isBefore(currentDate) || task.isFinished) {
                            Text(text = "Task Finished", style = MaterialTheme.typography.titleSmall)
                        } else {
                            Text(text = "End in: ${it.formatToString()}", style = MaterialTheme.typography.titleSmall)
                        }
                    }
                }
            }

            IconButton(
                onClick = { confirmDelete() },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Excluir tarefa",
                    tint = Red
                )
            }
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "Confirmar Exclusão")
            },
            text = {
                Text("Você tem certeza que deseja excluir essa tarefa?")
            },
            confirmButton = {
                TextButton(onClick = { Deletion() }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { cancelDeletion() }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
