package com.example.finaloncomp.ui.theme

// Import statements should all be from material3 for consistency
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.finaloncomp.service.ApiService
import com.example.finaloncomp.service.createApiService


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    var programName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val apiService = remember { createApiService() }

    Scaffold(
        containerColor = Color(0xFF282828),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFFFFC107),
                icon = { Icon(Icons.Filled.Add, contentDescription = "Add") },
                text = { Text("Add") }
            )
        },
        floatingActionButtonPosition = FabPosition.Center, // Correct position
        // Removed `isFloatingActionButtonDocked` as it might not be in Material 3

    ){ innerPadding ->
        BodyContent(
            innerPadding = innerPadding,
            showDialog = showDialog,
            programName = programName,
            onProgramNameChange = { programName = it },
            description = description,
            onDescriptionChange = { description = it },
            apiService = apiService ,
            navController = navController
        )
    }

    if (showDialog) {
        CreateProgramDialog(
            programName = programName,
            onProgramNameChange = { programName = it },
            description = description,
            onDescriptionChange = { description = it },
            onDismiss = { showDialog = false },
            onSave = {
                // Handle save action
                showDialog = false
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BodyContent(
    innerPadding: PaddingValues,
    showDialog: Boolean,
    programName: String,
    onProgramNameChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    apiService: ApiService,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        UserProfile()
        Spacer(Modifier.height(8.dp))
        WeekCalendar()
        Spacer(Modifier.height(8.dp))
        MyWorkoutsHeading()
        Spacer(Modifier.height(3.dp))
        WorkoutCardsRow(navController)
        Spacer(Modifier.height(8.dp))
        ReadyWorkoutsHeading()
        Spacer(Modifier.height(3.dp))
        ReadyWorkoutCardsRow(apiService)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProgramDialog(
    programName: String,
    onProgramNameChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = Color(0xFF282828)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Create a Program", style = MaterialTheme.typography.titleMedium, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = programName,
                    onValueChange = onProgramNameChange,
                    label = { Text("Program name", color = Color.White) }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = description,
                    onValueChange = onDescriptionChange,
                    label = { Text("Description (Optional)", color = Color.White) }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss,) {
                        Text("Cancel", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = onSave,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFC107) // Use 'containerColor', not 'backgroundColor'
                        )
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Composable
fun MyWorkoutsHeading() {
    Text(
        text = "My Workouts",
        color = Color.White,
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun ReadyWorkoutsHeading() {
    Text(
        text = "Ready Workouts",
        color = Color.White,
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}