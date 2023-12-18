package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finaloncomp.R

@Composable

fun SystemExercisesScreen() {
    var searchText by remember { mutableStateOf("") }
    val allExercises = listOf(
        ExerciseCategory("Abs", R.drawable.abdomen4),
        ExerciseCategory("Back", R.drawable.abdomen4),
        ExerciseCategory("Biceps", R.drawable.abdomen4),
        ExerciseCategory("Chest", R.drawable.abdomen4),
        ExerciseCategory("Cardio", R.drawable.abdomen4),
        ExerciseCategory("Calves", R.drawable.abdomen4),
        ExerciseCategory("Deltoids", R.drawable.abdomen4),
        ExerciseCategory("Forearms", R.drawable.abdomen4),
        ExerciseCategory("Hamstrings", R.drawable.abdomen4),
        ExerciseCategory("Quads", R.drawable.abdomen4),
        ExerciseCategory("Stretching", R.drawable.abdomen4),
        ExerciseCategory("Triceps", R.drawable.abdomen4),
    )
    val filteredExercises = allExercises.filter { it.name.contains(searchText, ignoreCase = true) }

    Column {
        Spacer(Modifier.height(26.dp))
        CustomSearchBar(searchText = searchText, onSearchTextChange = { searchText = it })
        Spacer(Modifier.height(26.dp))
        ExerciseTitle()
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(filteredExercises) { exerciseCategory ->
                ExerciseItem(exerciseCategory = exerciseCategory)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchText,
        onValueChange = onSearchTextChange,
        placeholder = { Text("Search anything") },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.LightGray,
                modifier = Modifier.size(20.dp)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.DarkGray,
            textColor = Color.White,
            cursorColor = Color.White,
            placeholderColor = Color.LightGray
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    )
}
@Composable
fun ExerciseTitle() {
    Text(
        text = "Exercises",
        color = Color.White,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
    )
}
