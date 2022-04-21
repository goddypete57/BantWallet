package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun HomeScreen() {
    var colorGrade = Brush.horizontalGradient(colors = listOf(
        Color(215, 3, 255),
        Color(130, 0, 255),
        Color(21, 33, 255),
        Color(0, 39, 255),
    ))

    val sanSansFamily = FontFamily(
        Font(R.font.source_sans_regular, FontWeight.Normal),
        Font(R.font.source_sans, FontWeight.SemiBold)
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        topBar = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.Transparent), verticalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .background(Color.Transparent), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.images), modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        ), contentDescription = "profile picture")
                    Row() {
                        androidx.compose.material.Text(text = "Etherium Main", fontSize = 24.sp, fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold)
                        Icon(painter = painterResource(id = R.drawable.vector_down), contentDescription = "pop up", modifier = Modifier.clickable {  })
                    }
                    Box(modifier = Modifier)
                }
                Divider()
            }
        },
        content = {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    androidx.compose.material.Text(text = "9.3729 ETH", fontSize = 55.sp, fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .padding(top = 24.dp)
                        .graphicsLayer(alpha = .99f)
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(colorGrade, blendMode = BlendMode.SrcAtop)
                            }
                        }
                    )
                }
                Row() {
                    androidx.compose.material.Text(text = "$19,328.19")
                    androidx.compose.material.Text(text = "+0.7%")
                }
            }

        }
    ) 
}