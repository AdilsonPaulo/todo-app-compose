package com.adilson.firstapplication.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adilson.firstapplication.data.TaskViewModel
import com.adilson.firstapplication.ui.theme.Purple40
import com.adilson.firstapplication.ui.theme.White


@SuppressLint("NewApi", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(){
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val taskViewModel: TaskViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Tasks")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40,
                    titleContentColor = White
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {showBottomSheet = true},
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = White
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = White,
                )
            }
        }

    ) {innerPadding ->
        TaskList(
            taskViewModel = taskViewModel,
            modifier = Modifier.padding(innerPadding)
        )
        if(showBottomSheet){
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                TaskForm(onTaskAdded = {
                    showBottomSheet = false
                })
            }
        }
    }
}