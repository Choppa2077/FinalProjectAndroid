package com.example.finaloncomp.ui.theme

import androidx.compose.material3.Text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finaloncomp.ui.theme.FInalOnCompTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finaloncomp.R


@Composable
fun MainContent(navController: NavController) {
    val openDialog = remember { mutableStateOf(false) }
    // Define the background color for the entire screen
    val backgroundColor = Color(0xFF282828) // Replace with your desired color

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor // Set the background color
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            WorkoutScreen(navController)
            WorkoutTimeline(navController)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        if (openDialog.value) {
            // Semi-transparent dark overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { openDialog.value = false }
                    )
            )
        }
        FloatingActionButton(
            onClick = { openDialog.value = true },
            modifier = Modifier.padding(16.dp),
            backgroundColor = Color(0xFFFFA500)
            // Set the colors according to your theme
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Workout")
        }

        // Display the modal dialog when the FAB is clicked
        if (openDialog.value) {
            AddWorkoutDialog(onDismiss = { openDialog.value = false })
        }
    }
}
@Composable
fun AddWorkoutDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            color = Color(0xFF2C2C2C) // Dialog background color
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Add Workout",
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
                OutlinedTextField(
                    value = "Name",
                    onValueChange = { /* Handle text change */ },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                        backgroundColor = Color(0xFFA09B9B),
                        cursorColor = Color.White,
                        focusedBorderColor = Color(0xFFA09B9B), // When the TextField is in focus
                        unfocusedBorderColor = Color(0xFFA09B9B) // When the TextField is not in focus
                    ),
                    shape = RoundedCornerShape(16.dp), // Slightly rounded corners
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 24.dp)

                )
                // Add day checkboxes here...
                // Add day checkboxes here...
                // Add day checkboxes here...
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ensure the row takes up the full width available
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly // Distribute the children evenly with equal space
                ) {
                    // Dummy data for checkboxes
                    val daysOfWeek = listOf("Mo", "Tu", "We", "Th", "Fr")
                    val checkedState = remember { mutableStateOf(Array(daysOfWeek.size) { false }) }

                    daysOfWeek.forEachIndexed { index, day ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = day, color = Color.White)
                            Checkbox(
                                checked = checkedState.value[index],
                                onCheckedChange = { isChecked ->
                                    checkedState.value[index] = isChecked
                                },
                                colors = CheckboxDefaults.colors(checkedColor = Color.White, uncheckedColor = Color.Gray)
                            )
                        }
                    }
                }

                // Add cancel and save buttons here...
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { /* Handle cancel */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)) // Orange color for the button
                    ) {
                        Text("Cancel", color = Color.White)
                    }
                    Button(
                        onClick = { /* Handle save */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)) // Orange color for the button
                    ) {
                        Text("Save", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FInalOnCompTheme {
        // Create a fake NavController that doesn't do anything
        val fakeNavController = rememberNavController()
        MainContent(fakeNavController)
    }
}
@Composable
fun WorkoutScreen(navController: NavController) {
    val Brown = Color(0xFF282828)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brown)
    ) {
        TopAppBar(
            title = { Text("", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Go back", tint = Color.White)
                }
            },
            backgroundColor = Brown
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp)
            // .background(Color(0x66000000))
        ) {
            Image(
                painter = painterResource(id = R.drawable.girlimage),
                contentDescription = "Abdomen workout image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp)),
                contentScale = ContentScale.Crop // Ensures the image fills the width of the Box
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .clip(RoundedCornerShape(12.dp)),
//                    .background(Color(0x66000000)) // Semi-transparent black background
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Abdomen",
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp)) //pace between the texts
                    Text(
                        "It seems like you're interested in abdominal exercises, which are exercises that target the muscles in your abdomen, commonly referred to as the \"abs.\"",
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
        // Your Timeline Composable goes here...
    }

}
@Composable
fun WorkoutTimeline(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
            .background(Color(0xFF282828)) // Set the background color of the column
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Example of a single workout item
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White) // Circle background color
            ) {
                Text(
                    text = "Sun",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
                    .clickable { navController.navigate(ScreenRoutes.NEW) }
            ) {
                Text(
                    text = "Workout A",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "5 exercises",
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable.gym), // Replace with your actual photo resource
                contentDescription = "Exercise photo",
                modifier = Modifier.size(24.dp) // Adjust the size as needed
            )
        }

        // Add another workout item for "Mon", "Workout B", etc.
        // ...
        Divider(
            color = Color.White,
            thickness = 1.dp,
            modifier = Modifier
                .padding(26.dp)
                .padding(vertical = 1.dp) // Give padding to vertical line
                .width(3.dp)
                .height(50.dp) // Vertical line height

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White) // Circle background color
            ) {
                Text(
                    text = "Mon",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
                    .clickable { navController.navigate(ScreenRoutes.NEW) }
            ) {
                Text(
                    text = "Workout B",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "5 exercises",
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable.gym), // Replace with your actual photo resource
                contentDescription = "Exercise photo",
                modifier = Modifier.size(24.dp) // Adjust the size as needed
            )
        }
    }
}



@Composable
fun Timeline() {
    // Define your Timeline composable here
}

// Continue defining other composables as needed.
