package com.adilson.firstapplication.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adilson.firstapplication.data.TaskViewModel
import com.adilson.firstapplication.domain.model.Task
import com.adilson.firstapplication.ui.theme.White
import com.adilson.firstapplication.utils.formatToString
import com.adilson.firstapplication.view.ui_components.ShowDatePicker
import java.time.LocalDate


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NewApi")
@Composable
fun TaskForm(onTaskAdded: () -> Unit){
    var title by remember { mutableStateOf("") }
    var showPicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val taskViewModel: TaskViewModel = viewModel()

    Scaffold {
        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it},
                    label = { Text("Title")},
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        val task = Task(
                            isFinished = false,
                            endDate = selectedDate,
                            annotation = null,
                            title = title,
                            creationDate = LocalDate.now()
                        )
                        taskViewModel.addTask(task)
                        onTaskAdded()
                    },
                    enabled = title.isNotBlank(),
                    modifier = Modifier.width(50.dp).height(50.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }


            if(showPicker){
                ShowDatePicker (
                    onDismiss = { showPicker = false },
                    onDateSelected = { date ->
                        selectedDate = date
                        showPicker = false
                    }
                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Button(
                    onClick = {showPicker = true},
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = White,
                        )
                        Text(text = "Fisish Date")
                    }
                }

                if(selectedDate != null){
                    Text(text = "Selected Date: ${selectedDate!!.formatToString()}", style = MaterialTheme.typography.titleSmall)
                }
            }
        }
    }
}