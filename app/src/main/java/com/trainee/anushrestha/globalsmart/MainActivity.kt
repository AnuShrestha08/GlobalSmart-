package com.trainee.anushrestha.globalsmart


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trainee.anushrestha.globalsmart.ui.theme.GlobalSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalSmartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GlobalApp()
                }
            }
        }
    }
}

@Composable
fun GlobalApp(modifier : Modifier = Modifier) {
    var enterNumber by remember{ mutableStateOf("")}
    var enterPassword by remember{ mutableStateOf("")}

    Column(

        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
    ){

                        //FIRST row
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
                ){
            Text(
                text = "GlobalSmart+",
                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .padding(top=44.dp),
                color = Color.Blue,
                fontSize = 30.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_scanner),
                contentDescription = "Scanner",
                modifier = Modifier
//                    .align(Alignment.TopEnd)
                    .alpha(0.5f),



            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Scanner",
                modifier = Modifier
                    .alpha(0.5f)


            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notiications),
                contentDescription = "Scanner",
                modifier = Modifier
                    .alpha(0.5f)

            )

        }

        Spacer(modifier = Modifier
            .height(20.dp)
        )

                //Next Column Started
            Text(
                text = "Hi Maria!",

                fontWeight = FontWeight.Bold

            )
            Text(
                text = "Good Morning",

            )

        Spacer(modifier = Modifier
            .height(20.dp)
        )

            OutlinedTextField(
                value = enterNumber,
                onValueChange = {enterNumber = it},
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = "Mobile Number")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )

            )

        Spacer(modifier = Modifier
            .height(10.dp)
        )

            OutlinedTextField(
                value = enterPassword,
                onValueChange = {enterPassword = it},
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = "Password *")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription ="password",

                    )
                }

            )

        Text(
            text = "Forget password?",
            color = Color.Blue,
            modifier = Modifier
                .alpha(0.5f)
                .align(Alignment.End)
            )

        Spacer(modifier = Modifier
            .height(10.dp)
        )

                    //BUTTON row


        Button(
            onClick = {
           // Toast.makeText(this, "LOG IN", Toast.LENGTH_SHORT).show()
        },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            enabled = true,

            //shape = MaterialTheme.
        ) {
            Text(
                text = "LOG IN",
                color = Color.White
            )


        }

        Spacer(modifier = Modifier
            .height(10.dp)
        )

        Row(horizontalArrangement = Arrangement.SpaceEvenly){
            Text(
                text = "Don't have an Log IN?"
            )

//            TextButton(onClick = { }) {
                Text(
                    text = "Register Now" ,
                    color = Color.Blue,
                    modifier = Modifier
                        .alpha(0.5f)

                )


            //}
        }


        Spacer(modifier = Modifier
            .height(20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.component_11),
            contentDescription = "corousel",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )


        Spacer(modifier = Modifier
            .height(25.dp)
        )

        Text(
            text = "Global IME Bank | Copyright 2021. All rights reserved.",
            modifier = Modifier
                .alpha(0.5f),
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )







    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GlobalSmartTheme {
        GlobalApp()
    }
}