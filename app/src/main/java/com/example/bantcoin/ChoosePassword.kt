package com.example.bantcoin

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bantcoin.ui.theme.Ash
import com.example.bantcoin.ui.theme.Purple
import com.example.bantcoin.ui.theme.Purple500
import com.example.bantcoin.ui.theme.TextColor

@Composable
fun ChoosePassword() {
    val currentStep = remember { mutableStateOf(0) }
    val securityLevel = remember { mutableStateOf(0) }
    val currentStepMove = remember { mutableStateOf(0) }
    val navController = rememberNavController()
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
        Box(
            Modifier.verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
//            NavigationGraph(navController = navController)

            when (currentStep.value) {
                0 -> {
                    var password by rememberSaveable { mutableStateOf("") }
                    val isSwitchChecked = remember { mutableStateOf(true) }
                    val isBoxChecked = remember { mutableStateOf(false) }
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        GradientText(
                            text = "Create Password",
                            modifier = Modifier
                                .padding(30.dp)
                                .wrapContentSize(),
                            fontSize = 20,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(30.dp))
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
                                .padding(20.dp)
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
                                .padding(20.dp)
                                .fillMaxWidth(),
                        )

                        Divider(
                            Modifier.padding(20.dp),
                            color = Ash, thickness = 2.dp
                        )


                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Sign in with fingerprint",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16,
                                textAlign = TextAlign.Start,
                                color = TextColor,
                                modifier = Modifier
                                    .wrapContentSize()
                            )
                            Switch(
                                checked = isSwitchChecked.value,
                                onCheckedChange = {
                                    isSwitchChecked.value = !isSwitchChecked.value
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Purple
                                )
                            )
                        }

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start)
                                .padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Checkbox(
                                checked = isBoxChecked.value,
                                onCheckedChange = { isBoxChecked.value = !isBoxChecked.value },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Purple
                                )
                            )

                            Text(
                                text = "I understand that Metacoin cannot recover this password for me. Learn more",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16,
                                textAlign = TextAlign.Start,
                                color = TextColor,
                                modifier = Modifier
                                    .wrapContentSize()
                            )

                        }

                        GradientButton(
                            text = "Create Password",
                            gradient = colorGrade,
                            modifier = Modifier.padding(20.dp)
                        ) {
                            currentStep.value = 1
                            /*navController.navigate("step2"){
                                popUpTo("step1"){inclusive = true}
                            }*/
                        }

                    }
                }

                1 -> {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.splash_image),
                            contentDescription = ""
                        )

                        GradientText(
                            text = "Secure Your Wallet",
                            modifier = Modifier
                                .padding(30.dp)
                                .wrapContentSize(),
                            fontSize = 20,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "Don't risk losing your funds. Protect your wallet by saving your Seed phrase in a place\n" +
                                    "you trust. ",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16,
                            textAlign = TextAlign.Center,
                            color = TextColor,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                        )

                        Text(
                            text = "It's the only way to recover your wallet if you get locked out of the app or get a new device.",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16,
                            textAlign = TextAlign.Center,
                            color = TextColor,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(10.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlineButton(
                            text = "Remind me later",
                            modifier = Modifier.padding(20.dp)
                        )
                        GradientButton(
                            text = "Create Password",
                            gradient = colorGrade,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }

            }


        }

    }

}

@Composable
fun Step1(navController: NavHostController) {
    var password by rememberSaveable { mutableStateOf("") }
    val isSwitchChecked = remember { mutableStateOf(true) }
    val isBoxChecked = remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GradientText(
            text = "Create Password",
            modifier = Modifier
                .padding(30.dp)
                .wrapContentSize(),
            fontSize = 20,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))
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
                .padding(20.dp)
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
                .padding(20.dp)
                .fillMaxWidth(),
        )

        Divider(
            Modifier.padding(20.dp),
            color = Ash, thickness = 2.dp
        )


        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Sign in with fingerprint",
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                textAlign = TextAlign.Start,
                color = TextColor,
                modifier = Modifier
                    .wrapContentSize()
            )
            Switch(
                checked = isSwitchChecked.value,
                onCheckedChange = { isSwitchChecked.value = !isSwitchChecked.value },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Purple
                )
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(checked = isBoxChecked.value,
                onCheckedChange = { isBoxChecked.value = !isBoxChecked.value })

            Text(
                text = "I understand that Metacoin cannot recover this password for me. Learn more",
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                textAlign = TextAlign.Start,
                color = TextColor,
                modifier = Modifier
                    .wrapContentSize()
            )

        }

        GradientButton(
            text = "Create Password",
            gradient = colorGrade,
            modifier = Modifier.padding(20.dp)
        ) {
            navController.navigate("step2") {
                popUpTo("step1") { inclusive = true }
            }
        }

    }
}

@Composable
fun Step2() {
    val securityLevel = remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            GradientText(
                text = "Secure Your Wallet",
                modifier = Modifier
                    .wrapContentSize(),
                fontSize = 20,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier.padding(top = 28.dp, start = 5.dp),
                painter = painterResource(id = R.drawable.ic_instruct),
                contentDescription = ""
            )
        }

        Row(Modifier.fillMaxWidth()) {
            Text(
                text = "Secure your wallet's",
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = TextColor,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(10.dp)
            )

            Text(
                text = "\"Seed Phrase\"",
                fontWeight = FontWeight.Normal,
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = Purple,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 10.dp)
            )
        }

        Text(
            text = "Manuel",
            fontWeight = FontWeight.Bold,
            fontSize = 16,
            textAlign = TextAlign.Start,
            color = TextColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Text(
            text = "Write down your seed phrase on a piece of paper and store in a safe place.",
            fontWeight = FontWeight.Normal,
            fontSize = 16,
            textAlign = TextAlign.Start,
            color = TextColor,
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        )

        Text(
            text = "Security level: Very strong",
            fontWeight = FontWeight.Normal,
            fontSize = 16,
            textAlign = TextAlign.Start,
            color = TextColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Row(
            Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Divider(
                Modifier.width(80.dp),
                color = when (securityLevel.value) {
                    0 -> Ash
                    1 -> Color.Red
                    3 -> Color.Yellow
                    else -> Color.Green
                },
                thickness = 3.dp
            )
            Spacer(modifier = Modifier.width(15.dp))
            Divider(
                Modifier.width(80.dp),
                color = when (securityLevel.value) {
                    1 -> Color.Yellow
                    3, 4, 5 -> Color.Green
                    else -> Ash
                },
                thickness = 3.dp
            )
            Spacer(modifier = Modifier.width(15.dp))

            Divider(
                Modifier.width(80.dp),
                color = Color.Green, thickness = 3.dp
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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "step1"
    ) {
        composable("step1") {
            Step1(navController)
        }
        composable("step2") {
            Step2()
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