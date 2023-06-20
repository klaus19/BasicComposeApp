package com.example.basiccomposeapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basiccomposeapp.db.SavedCard


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenLearn(savedCards: List<SavedCard>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Saved Data") })
        }
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(savedCards) { savedCard ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = savedCard.imageName, style = MaterialTheme.typography.h6)
                        Image(
                            painter = painterResource(id = savedCard.imageId),
                            contentDescription = savedCard.imageName,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .height(200.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(Color.LightGray)
                        )
                    }
                }
            }
        }
    }
}

