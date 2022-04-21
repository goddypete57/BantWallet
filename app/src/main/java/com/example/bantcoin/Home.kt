package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
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
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp), horizontalArrangement = Arrangement.Center) {
                    androidx.compose.material.Text(
                        text = "9.3729 ETH",
                        fontSize = 55.sp,
                        fontFamily = sanSansFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                        .graphicsLayer(alpha = .99f)
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(colorGrade, blendMode = BlendMode.SrcAtop)
                            }
                        }
                    )
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "$19,328.19", fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "+0.7%", fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, fontSize = 21.sp, color = Color(35, 167, 87))
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Row(
                        Modifier
                            .clip(RoundedCornerShape(50))
                            .background(color = Color(244, 246, 249))
                            .padding(horizontal = 15.dp, vertical = 8.dp)) {
                        Text(text = "0x7aCaaba8238.....96eEf19", fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(painter = painterResource(id = R.drawable.copy), contentDescription = "icon", modifier = Modifier
                            .height(18.dp)
                            .width(16.dp)
                            .clickable { /*TODO*/ })
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50), elevation = ButtonDefaults.elevation(0.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier
                        .height(43.dp)
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(colorGrade)
                        .align(alignment = Alignment.CenterVertically)) {
                        Icon(painter = painterResource(id = R.drawable.send), tint = Color.White, contentDescription = "send", modifier = Modifier
                            .height(16.dp)
                            .width(17.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Send", fontFamily = sanSansFamily, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50), elevation = ButtonDefaults.elevation(0.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier
                        .height(43.dp)
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(colorGrade)
                        .align(alignment = Alignment.CenterVertically)) {
                        Icon(painter = painterResource(id = R.drawable.recieve), tint = Color.White, contentDescription = "Receive", modifier = Modifier
                            .height(16.dp)
                            .width(17.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Receive", color = Color.White, fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50), elevation = ButtonDefaults.elevation(0.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier
                        .height(43.dp)
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(colorGrade)
                        .align(alignment = Alignment.CenterVertically)) {
                        Icon(painter = painterResource(id = R.drawable.buy), tint = Color.White, contentDescription = "Buy", modifier = Modifier
                            .height(16.dp)
                            .width(17.dp))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Buy", fontFamily = sanSansFamily, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                TabScreen()

            }

        }
    ) 
}