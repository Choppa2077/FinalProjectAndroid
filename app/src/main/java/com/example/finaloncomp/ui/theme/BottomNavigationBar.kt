package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun BottomNavigationBar(
    currentScreen: String,
    navController: NavHostController
) {
    // Define the background color at the top level of this composable
    val backgroundColor = Color(0xFF414141) // or any color you wish
    var currentScreen by remember { mutableStateOf("Home") } //

    NavigationBar(
        containerColor = backgroundColor, // Set the background color here
        tonalElevation = 0.dp,
        // Apply the rounded shape modifier
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
    ) {
        val items = listOf("Home",  "Exercises", "Program", "Program Exercises")
        val routes = listOf(ScreenRoutes.HOME,  ScreenRoutes.EXERCISES, ScreenRoutes.PROGRAM, ScreenRoutes.PROGRAM_EXERCISES)

        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = {
                    when (screen) {
                        "Home" -> Icon(Icons.Filled.Home, contentDescription = null)
                        "Exercises" -> Icon(Icons.Filled.FitnessCenter, contentDescription = null)
                        "Program" -> Icon(Icons.Filled.Person, contentDescription = null)
                        "Program Exercises" -> Icon(Icons.Filled.Person, contentDescription = null)
                        else -> Icon(Icons.Filled.Home, contentDescription = null)
                    }
                },
                label = { Text(text = screen) },
                selected = currentScreen == screen,
                onClick = {
                    if (currentScreen != screen) {
                        navController.navigate(screen) {
                            // Avoid multiple copies of the same destination when reselecting the same item
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                        // Directly update currentScreen if no additional action is needed
                        currentScreen = screen
                    }
                },
                // Define the colors for the selected and unselected state
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFC107),
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White
                )
            )
        }
    }
}