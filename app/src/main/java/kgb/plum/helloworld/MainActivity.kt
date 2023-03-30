package kgb.plum.helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kgb.plum.helloworld.ui.theme.HelloWorldTheme
import kgb.plum.helloworld.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                BoxEx()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        modifier = Modifier
            .size(300.dp)
            .padding(12.dp),
        color = Orange,
        text = "Hello $name\nHello $name\nHello $name",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Justify,
    )
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(3.dp, Color.Green),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
        ){
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}

@Composable
fun ModifierEx(){
    Button(
        onClick = {},
        modifier = Modifier.size(200.dp).padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Cyan,
            contentColor = Color.Magenta
        ),
    ){
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing)
            .background(Color.Blue)
        )
        Text(
            color = Color.Red,
            text = "Search",
            modifier = Modifier.offset(y = 10.dp)
                .background(Color.Blue)
            )
    }
}

@Composable
fun SurfaceEx(name: String){
    Surface(
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        shape = CircleShape,
        color = MaterialTheme.colors.error
    ){
        Text(
            text = "Hello $name",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BoxEx(){
    Box(){
        Box(modifier = Modifier.fillMaxSize().size(70.dp).background(Color.Cyan).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(70.dp).background(Color.Red).align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTheme {
        BoxEx()
    }
}