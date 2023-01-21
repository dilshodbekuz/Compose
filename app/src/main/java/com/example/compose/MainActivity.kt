package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)

                }

                ColorBox(
                    Modifier.fillMaxSize()
                        .weight(1f)){
                    color.value = it
                }
                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier,
updateColor:(Color)-> Unit) {


    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
                )
            )
        })

}


/* setContent {
     val painter = painterResource(id = R.drawable.image)
     val description = "Kermit in the snow"
     val tittle = "Kermit is play"
     Box(modifier = Modifier
         .fillMaxSize(0.5f)
         .padding(16.dp))
     ImageCard(painter = painter, contentDescription = description, tittle = tittle)
 }
}
}

@Composable
fun ImageCard(
painter: Painter,
contentDescription: String,
tittle: String,
modifier: Modifier = Modifier,
) {
Box(modifier = Modifier.height(200.dp)) {
 Image(painter = painter, contentDescription = contentDescription,
     contentScale = ContentScale.Crop)
 Box(modifier = Modifier.fillMaxSize()
     .background(Brush.verticalGradient(
         colors = listOf(
             Color.Transparent,
             Color.Black
         ),
         startY = 300f
     )))
 Box(modifier = Modifier
     .fillMaxSize(),
     contentAlignment = Alignment.BottomStart) {
     Text(tittle, style = TextStyle(color = Color.White, fontSize = 16.sp))
 }
}
}*/