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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bantcoin.ui.theme.Purple
import com.example.bantcoin.ui.theme.TextColor

@Composable
fun GetStarted() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(150.dp))
            Image(painter = painterResource(id = R.drawable.splash_image), contentDescription = "")
            Spacer(modifier = Modifier.height(90.dp))
            Text(
                text = "The best crypto wallet app\nof this century",
                fontWeight = FontWeight.Normal,
                fontSize = 18,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = TextColor
            )
            Spacer(modifier = Modifier.height(100.dp))
            GradientButton(text = "Get Started", gradient = colorGrade)
        }
    }
}

@Preview
@Composable
fun getstarted() {
    GetStarted()
}