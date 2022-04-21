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

@Composable
fun WalletComposable() {
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

            Spacer(modifier = Modifier.height(110.dp))
            Image(painter = painterResource(id = R.drawable.splash_image), contentDescription = "")
            Spacer(modifier = Modifier.height(90.dp))
            GradientText(
                text = "Wallet Setup",
                fontWeight = FontWeight.Bold,
                fontSize = 25,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(50.dp))
            OutlineButton(text = "Importing using see phrase") {

            }
            Spacer(modifier = Modifier.height(20.dp))
            GradientButton(text = "Get Started", gradient = colorGrade) {

            }
        }
    }
}

@Preview
@Composable
fun wallet() {
    WalletComposable()
}