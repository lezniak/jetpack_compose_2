package com.example.myapplication.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.Workout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    YourBodySegment(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun YourBodySegment(modifier: Modifier = Modifier){
    val list = listOf<Workout>(Workout(R.string.gym_workout,R.drawable.workout1),Workout(R.string.yoga_workout,R.drawable.w1),Workout(R.string.fast_yoga_workout,R.drawable.w2),Workout(R.string.tabata_workout,R.drawable.w3),Workout(R.string.quick_yoga_workout,R.drawable.w4))
    LazyRow(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = list){ item ->
            WorkoutCard(drawable = item.image, text = item.name, modifier = Modifier)
        }
    }
}

@Composable
@Preview
private fun YourBodyPreview(){
    YourBodySegment()
}