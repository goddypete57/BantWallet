package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(6000L)
        navController.navigate("onBoarding_Screen")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
                verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = com.example.bantcoin.R.drawable.splash_image), contentDescription ="" )
        }
}
@Preview
@Composable
fun splash() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}