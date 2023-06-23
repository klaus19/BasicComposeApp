package com.example.basiccomposeapp

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.basiccomposeapp.db.SavedCard
import com.example.basiccomposeapp.ui.theme.model.ImageModel



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenPlay(navController: NavController){

    // Mutable state to hold the dynamically updated saved cards
    var savedCards by remember { mutableStateOf(emptyList<SavedCard>()) }

    lateinit var playList:List<ImageModel>
    playList = ArrayList()
    playList = listOf(
        ImageModel("TNT",R.drawable.television,R.drawable.save),
                   ImageModel("nt",R.drawable.food,R.drawable.save),
                   ImageModel("xyz",R.drawable.dish,R.drawable.save),
                   ImageModel("gggg",R.drawable.bird,R.drawable.save)
    )
    val context = LocalContext.current

    val cardViewmodel: ScreenViewModel = viewModel(
        factory = ScreenViewmodelFactory((context.applicationContext as MyApp).repository)
    )


  //  val navController = rememberNavController()
//For using the object on ArrowBack Icon
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Days") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {

                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { onBackPressedDispatcher?.onBackPressed() }
                    )

                }
            }

        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                      navController.navigate(Destinations.ScreenLearn)
            },
                modifier = Modifier.padding(bottom = 50.dp, end = 40.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Save"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .padding(bottom = 56.dp)
                .navigationBarsPadding()
        ) {
            items(playList.size) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .height(150.dp),
                    elevation = 6.dp,
                ) {
                    Box{
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                                .background(Color(153, 50, 204))
                                .clip(RoundedCornerShape(20.dp)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Image(
                                painter = painterResource(id = playList[it].imageId),
                                contentDescription = "Images"
                            )

                            Spacer(modifier = Modifier.padding(bottom = 5.dp))
                            Text(
                                text = playList[it].imageName,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }
                        Image(painter = painterResource(id = playList[it].imageSaved), contentDescription = "Save data",
                            modifier = Modifier
                                .padding(8.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.TopEnd)
                                .clickable {

                                    val imagename = playList[it].imageName
                                    val imageResource = playList[it].imageId

                                    val newSaved =
                                        SavedCard(imageId =imageResource, imageName = imagename)
                                    savedCards += newSaved
                                    cardViewmodel.insertCards(newSaved)
                                    Log.d("Database", "Value saved: $newSaved")
                                    Toast.makeText(context,"Image saved", Toast.LENGTH_SHORT).show()


                                }
                        )
                    }

                }
            }
        }
    }

    }

