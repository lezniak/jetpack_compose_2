package com.example.myapplication.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.Favourite
import com.example.myapplication.model.Workout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        YourBodySegment(Modifier.padding(innerPadding))
                        FavouriteSegment()
                    }
                }
            }
        }
    }
}

@Composable
private fun YourBodySegment(modifier: Modifier = Modifier){
    val list = listOf<Workout>(Workout(1,R.string.gym_workout,R.drawable.workout1),Workout(2,R.string.yoga_workout,R.drawable.w1),Workout(3,R.string.fast_yoga_workout,R.drawable.w2),Workout(4,R.string.tabata_workout,R.drawable.w3),Workout(5,R.string.quick_yoga_workout,R.drawable.w4))
    LazyRow(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = list, key = { item -> item.id}){ item ->
            WorkoutCard(drawable = item.image, text = item.name, modifier = Modifier)
        }
    }
}

@Composable
private fun FavouriteSegment(modifier: Modifier = Modifier){
    val list = listOf(Favourite(1,R.string.night_weather,R.drawable.night),Favourite(2,R.string.rainy_weather,R.drawable.rain),Favourite(3,R.string.sunny_weather,R.drawable.sunny),Favourite(4,R.string.cloudy_weather,R.drawable.cloud))

    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)) {
        items(list, key = { item -> item.id}) { item ->
            FavouriteCard(drawable = item.icon, text = item.name, modifier = Modifier)
        }
    }
}

@Composable
@Preview
private fun YourBodyPreview(){
    FavouriteSegment()
}