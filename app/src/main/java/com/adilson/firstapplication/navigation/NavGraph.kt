package com.adilson.firstapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adilson.firstapplication.view.screens.TodoApp

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier){
    NavHost(navController, startDestination = "TodoApp", modifier = modifier){
        composable("TodoApp"){
            TodoApp()
        }
    }
}