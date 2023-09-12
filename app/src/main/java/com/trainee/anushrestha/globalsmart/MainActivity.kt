package com.trainee.anushrestha.globalsmart


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarDefaults.backgroundColor
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.google.android.gms.wallet.button.ButtonConstants
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
    Column(
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ){
        FirstRow()

        Greetings()

        MobileNumber()

        ShowHidePasswordTextField()

        ForgetPasswordText(modifier = Modifier.align(Alignment.End))

        LogInFingerprint()

        RegisterNow()

        Image(
            painter = painterResource(id = R.drawable.component_11),
            contentDescription = "carousel",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier
            .height(10.dp)
        )

        ScrollingScreen()

        GlobalCopyrightText(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun FirstRow(){
    Row (
        modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "GlobalSmart+",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_button),
            style = MaterialTheme.typography.titleLarge
        )
        Row (
            modifier= Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_scanner),
                contentDescription = "Scanner",
                modifier = Modifier
//                    .align(Arrangement.End)
                    .alpha(0.5f),


                )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Scanner",
                modifier = Modifier
                    .alpha(0.5f)
                    .height(30.dp)


            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notiications),
                contentDescription = "Scanner",
                modifier = Modifier
                    .alpha(0.5f)

            )
        }

    }
    Spacer(modifier = Modifier
        .height(20.dp)
    )

}

@Composable
fun Greetings(){
    Text(
        text = "Hi Maria!",
        style = MaterialTheme.typography.headlineLarge,
    )
    Text(
        text = "Good Morning",
        style = MaterialTheme.typography.bodyMedium,
        )
    Spacer(modifier = Modifier
        .height(20.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MobileNumber(){
    var isExpanded by remember { mutableStateOf(false)}
    var enterNumber by remember{ mutableStateOf("")}


//    ExposedDropdownMenuBox(
//        expanded = isExpanded,
//        onExpandedChange ={
//            newValue -> isExpanded = newValue
//        }
//    ) {
        OutlinedTextField(
            value = enterNumber,
            onValueChange = {enterNumber = it},
            label = {
                Text(text = "Mobile Number")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(text = "+977")
            },
//            readOnly = true,
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
//            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),

        )

//
//    }


    Spacer(modifier = Modifier
        .height(10.dp)
    )
}

@Composable
fun ShowHidePasswordTextField(){
    var password by remember{ mutableStateOf("")}
    var showPassword by remember{ mutableStateOf(false)}

    OutlinedTextField(
        value = password,
        onValueChange = {password = it},
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        label = {
            Text(text = "Password ***")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        placeholder = {
            Text(text = "Type password here...")
        },
        shape = RoundedCornerShape(20),
       // visualTransformation = PasswordVisualTransformation(),
        visualTransformation = if(showPassword){
            VisualTransformation.None
        }else {
            PasswordVisualTransformation()
        },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_lock),
                contentDescription ="password",
                )
        }


    )


}

@Composable
fun ForgetPasswordText( modifier: Modifier = Modifier){
        Text(
            text = "Forget password?",
            color = colorResource(id = R.color.blue_button),
            modifier = modifier.padding(top = 13.dp),
            style = MaterialTheme.typography.bodyMedium

        )
    Spacer(modifier = Modifier
        .height(10.dp)
    )
}

@Composable
fun LogInFingerprint(){
    Button(
        shape = RectangleShape,
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        enabled = true,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue_button))

    ) {
        Text(
            text = "LOG IN",
            color = Color.White
        )
    }

    Spacer(modifier = Modifier
        .height(10.dp)
    )
}

@Composable
fun RegisterNow(){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Text(
            text = "Don't have an Log In?",
            style = MaterialTheme.typography.bodyMedium

        )
        Text(
            text = "Register Now" ,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.blue_button),
        )
    }

    Spacer(modifier = Modifier
        .height(20.dp)
    )
}

@Composable
fun ScrollingScreen(){
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())){
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.component_11),
            contentDescription = "first",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.n9),
            contentDescription = "second",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.n10),
            contentDescription = "third",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.n10),
            contentDescription = "third",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.n10),
            contentDescription = "third",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

    Spacer(modifier = Modifier
        .height(35.dp)
    )

}

@Composable
fun GlobalCopyrightText(modifier:Modifier = Modifier){
    Text(
        text = "Global IME Bank | © Copyright 2021. All rights reserved.",
        modifier = modifier
            .alpha(0.5f),
        fontSize = 10.sp,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GlobalSmartTheme {
        GlobalApp()
    }
}