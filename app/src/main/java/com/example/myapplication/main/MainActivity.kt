package com.example.myapplication.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.model.Favourite
import com.example.myapplication.model.Workout
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.utlis.SearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { SootheBottomNavigation() },
                    topBar = {}) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun HomeSection(modifier: Modifier = Modifier,content : @Composable () -> Unit,@StringRes title: Int){
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
private fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier) {
        Spacer(Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(content = { YourBodySegment() }, title = R.string.align_body)
        HomeSection(content = { FavouriteSegment() }, title = R.string.favourite)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
private fun HomeSectionPrev(){
    HomeScreen()
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

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}