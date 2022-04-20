package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GetStarted(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(100.dp))
            Image(painter = painterResource(id = R.drawable.splash_image), contentDescription ="" )
            Spacer(modifier = Modifier.height(12.dp))
            GradientText(text = "show",modifier = Modifier.fillMaxWidth(),fontSize = 20,fontWeight = FontWeight.Bold)

        }
    }
}

@Preview
@Composable
fun getstarted() {
    GetStarted()
}