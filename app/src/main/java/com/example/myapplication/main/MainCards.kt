package com.example.myapplication.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplication.R

@Composable
fun WorkoutCard(modifier: Modifier, @DrawableRes drawable : Int, @StringRes text : Int){
    val painter = rememberImagePainter(data = drawable)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
        Image(painter = painter,
            contentDescription = "workout_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape))

        Text(text = stringResource(id = text), modifier = modifier.padding(top = 24.dp), fontSize = 22.sp)
    }
}

@Composable
private fun WorkoutCardPreview(){
    WorkoutCard(Modifier, R.drawable.workout1, R.string.gym_workout)
}

@Composable
fun FavouriteCard(modifier: Modifier = Modifier , @DrawableRes drawable: Int, @StringRes text: Int){
    val painter = rememberImagePainter(data = drawable)
    Surface(modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.primary) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(255.dp)) {
            Image(painter = painter,
                contentDescription = "workout_image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(80.dp)
                    .clip(RectangleShape)
            )

            Text(text = stringResource(id = text), modifier = modifier.padding(horizontal =  24.dp), fontSize = 22.sp)
        }
    }
}

@Composable
@Preview()
private fun FavouriteCardPreview(){
    FavouriteCard(Modifier, R.drawable.workout1, R.string.gym_workout)
}