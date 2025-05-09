package com.adilson.firstapplication.view.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.adilson.firstapplication.ui.theme.White

@Composable
fun RoundedCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    val color = if (checked) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }

    Box (
        modifier = Modifier
            .size(24.dp)
            .clip(shape = CircleShape)
            .background(color)
            .clickable { onCheckedChange(!checked) }
    ){
        if(checked){
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(16.dp)
            )
        }
    }
}