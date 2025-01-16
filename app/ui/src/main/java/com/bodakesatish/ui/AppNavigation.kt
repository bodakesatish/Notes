package com.bodakesatish.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bodakesatish.ui.notes.NoteListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            NoteListScreen(
                onNavigateToAddNote = { navController.navigate("add") }
            )
        }
    }
}