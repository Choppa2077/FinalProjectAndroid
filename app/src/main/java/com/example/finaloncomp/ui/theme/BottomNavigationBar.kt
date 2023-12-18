package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BottomNavigationBar(currentScreen: String, onNavigationSelected: (String) -> Unit) {
    val backgroundColor = Color(0xFF282828) // Define the color here

    NavigationBar(
        // Now apply the background modifier with the defined color
        modifier = Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .then(Modifier.padding(0.dp))
    ) {

        val items = listOf("Home", "Edit exercises", "Exercises", "Profile")
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    when (screen) {
                        "Home" -> Icon(Icons.Filled.Home, contentDescription = null)
                        "Edit exercises" -> Icon(Icons.Filled.Edit, contentDescription = null)
                        "Exercises" -> Icon(Icons.Filled.FitnessCenter, contentDescription = null)
                        "Profile" -> Icon(Icons.Filled.Person, contentDescription = null)
                        else -> Icon(Icons.Filled.Home, contentDescription = null)
                    }
                },
                label = { Text(text = screen) },
                selected = currentScreen == screen,
                onClick = { onNavigationSelected(screen) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFC107),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
