package com.example.bantcoin

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bantcoin.ui.theme.Purple500
import com.example.bantcoin.ui.theme.TextColor

@Composable
fun ChoosePassword() {
    var password by rememberSaveable { mutableStateOf("") }
    val currentStep = remember { mutableStateOf(3) }
    Scaffold(
        topBar = {
            TopAppBar(Modifier.height(80.dp), backgroundColor = Color.White) {
                Box(Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(24.dp)
                            .align(Alignment.CenterStart)
                    )
                    StepsProgressBar(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center),
                        numberOfSteps = 2,
                        currentStep = currentStep.value
                    )
                }

            }
        }
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientText(
                text = "Choose Password",
                modifier = Modifier
                    .padding(30.dp)
                    .wrapContentSize(),
                fontSize = 20,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "New Password",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18,
                    textAlign = TextAlign.Start,
                    color = TextColor,
                    modifier = Modifier
                        .wrapContentSize()
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = ""
                )
            }
            Fields(
                name = password,
                onNameChange = { password = it },
                placeholders = "New Password",
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Confirm Password",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18,
                    textAlign = TextAlign.Start,
                    color = TextColor,
                    modifier = Modifier
                        .wrapContentSize()
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = ""
                )
            }

            Fields(
                name = password,
                onNameChange = { password = it },
                placeholders = "New Password",
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Divider(
                Modifier.padding(20.dp),
                color = TextColor, thickness = 2.dp
            )


        }
    }

}


@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier,
                isCompete = step < currentStep,
                isCurrent = step == currentStep,
                last = step == numberOfSteps
            )
        }
    }
}

@Composable
fun Step(
    modifier: Modifier = Modifier,
    isCompete: Boolean,
    isCurrent: Boolean,
    last: Boolean
) {
    val color = if (isCompete || isCurrent) Purple500 else Color.LightGray
    val innerCircleColor = if (isCompete) Purple500 else Color.LightGray

    Box(modifier = modifier) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            //Circle
            Canvas(modifier = Modifier
                .size(15.dp)
                .border(
                    shape = CircleShape,
                    width = 2.dp,
                    color = color
                ),
                onDraw = {
                    drawCircle(color = innerCircleColor)
                }
            )

            if (!last) {
                //Line
                Divider(
                    modifier = Modifier
                        .width(100.dp),
                    color = innerCircleColor,
                    thickness = 2.dp
                )
            }
        }
    }
}

@Preview
@Composable
fun StepsProgressBarPreview() {
    ChoosePassword()
    /*val currentStep = remember { mutableStateOf(1) }
    StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 2, currentStep = currentStep.value)*/
}