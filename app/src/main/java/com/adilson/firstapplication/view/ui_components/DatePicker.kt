package com.adilson.firstapplication.view.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("NewApi")
fun ShowDatePicker(
    onDismiss: () -> Unit,
    onDateSelected: (LocalDate) -> Unit
    ){
    val datePickerState = rememberDatePickerState()

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface (
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp
        ){
            Column (
                modifier = Modifier.padding(8.dp)
            ){
                DatePicker(state = datePickerState)

                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ){
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text(text = "Cancelar")
                    }

                    TextButton(
                        onClick = {
                            val selectedMillis = datePickerState.selectedDateMillis
                            if (selectedMillis != null){
                                val selectedDate = Instant.ofEpochMilli(selectedMillis)
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate()
                                onDateSelected(selectedDate)
                            }
                            onDismiss()
                        }
                    ) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
