package com.example.myapplication.utlis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(value = "", 
        onValueChange = {}, 
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = { Image(imageVector = Icons.Filled.Search, contentDescription = "search_icon")},
        placeholder = {
            Text(text = stringResource(id = R.string.search))
        })
}

@Preview
@Composable
fun SearchBarPreview(){
    SearchBar(modifier = Modifier)
}