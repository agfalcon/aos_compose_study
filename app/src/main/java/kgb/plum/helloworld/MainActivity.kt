package kgb.plum.helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
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
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this, "Send clicked.", Toast.LENGTH_SHORT).show()
                })
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTheme {
        ButtonExample(onButtonClicked = {})
    }
}