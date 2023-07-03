package com.example.basiccomposeapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.basiccomposeapp.ui.theme.model.ImageModel
import com.example.basiccomposeapp.ui.theme.model.ScreenAmodel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScreenA(navController:NavController) {

    lateinit var birdList:List<ScreenAmodel>
    birdList = ArrayList()
    birdList = listOf(
        ScreenAmodel("Bird",R.drawable.bird), ScreenAmodel("Dish",R.drawable.dish),
        ScreenAmodel("food",R.drawable.food), ScreenAmodel("television",R.drawable.television),
        ScreenAmodel("Bird",R.drawable.bird), ScreenAmodel("Dish",R.drawable.dish),
        ScreenAmodel("food",R.drawable.food), ScreenAmodel("television",R.drawable.television),
        ScreenAmodel("Bird",R.drawable.bird), ScreenAmodel("Dish",R.drawable.dish),
        ScreenAmodel("food",R.drawable.food), ScreenAmodel("television",R.drawable.television),
        ScreenAmodel("Bird",R.drawable.bird), ScreenAmodel("Dish",R.drawable.dish),
        ScreenAmodel("food",R.drawable.food), ScreenAmodel("television",R.drawable.television)
    )


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(8.dp)
            .padding(bottom = 56.dp)
            .navigationBarsPadding()

    ) {
        itemsIndexed(birdList) { index, item ->
            Card(
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    when(index){
                        0 -> navController.navigate(Destinations.ScreenPlay)
                        1 -> navController.navigate(Destinations.ScreenB)
                    }
                },
                elevation = 6.dp,
                modifier = Modifier.padding(5.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color(153, 50, 204))
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = item.imageResource),
                        contentDescription = "BirdList",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = item.imageName,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }


}

