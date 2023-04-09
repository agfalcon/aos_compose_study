package kgb.plum.helloworld

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import kgb.plum.helloworld.MainActivity.Companion.cardData
import kgb.plum.helloworld.ui.theme.HelloWorldTheme
import kgb.plum.helloworld.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                TopBarEx("Android!")
            }
        }
    }

    companion object{
        val cardData = CardData(
            imageUri = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory&fname=https://k.kakaocdn.net/dn/EShJF/btquPLT192D/SRxSvXqcWjHRTju3kHcOQK/img.png",
            imageDescription = "종",
            author = "김근범",
            description = "말풍선 안의 종"
        )
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
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp),
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
        Spacer(modifier = Modifier
            .size(ButtonDefaults.IconSpacing)
            .background(Color.Blue)
        )
        Text(
            color = Color.Red,
            text = "Search",
            modifier = Modifier
                .offset(y = 10.dp)
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
        Box(modifier = Modifier
            .fillMaxSize()
            .size(70.dp)
            .background(Color.Cyan)
            .align(Alignment.CenterStart))
        Box(modifier = Modifier
            .size(70.dp)
            .background(Color.Red)
            .align(Alignment.Center))
    }
}

@Composable
fun RowEx(){
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)){
        Text(text = "첫 번째!",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
                .background(Color.Blue)
            )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가",
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )
        Text(text = "세 번째!",
            modifier = Modifier
                .weight(3f)
                .background(Color.Yellow),
            textAlign = TextAlign.End
            )
    }
}

@Composable
fun ColumnEx(){
    Column(modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        ){
        Text(
            text = "첫 번째!",
            modifier = Modifier.align(Alignment.Start)
        )
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }
}

@Composable
fun Outer(){
    Column(modifier = Modifier.width(150.dp)){
        Inner(modifier = Modifier
            .width(200.dp)
            .height(160.dp))
        Inner(modifier = Modifier
            .width(200.dp)
            .height(100.dp))
    }
}

@Composable
fun Inner(modifier: Modifier = Modifier){
    BoxWithConstraints(modifier) {
        if(maxHeight > 150.dp){
            Text(text = "여기 꽤 길군요!", textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.BottomCenter))
        }
        Text("maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight")
    }
}

@Composable
fun ImageEx(){
    Column{
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "고양이 수채화"
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Setting"
        )
    }
}

@Composable
fun CoilEx(){
//    val painter = rememberImagePainter(data  = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fdemo.ycart.kr%2Fshopboth_farm_max5_001%2Fbbs%2Fview_image.php%3Ffn%3Dhttp%253A%252F%252Fdemo.ycart.kr%252Fshopboth_cosmetics_001%252Fdata%252Feditor%252F1612%252Fcd2f39a0598c81712450b871c218164f_1482469221_493.jpg&psig=AOvVaw3sZjJ0gIAvKjcCMS7ZCi4G&ust=1681086597454000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCKiuvt3Fm_4CFQAAAAAdAAAAABAJ")
//    Column{
//        Image(
//            painter = painter,
//            contentDescription = "엔텔로프 케년"
//        )
//    }
    AsyncImage(model = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory&fname=https://k.kakaocdn.net/dn/EShJF/btquPLT192D/SRxSvXqcWjHRTju3kHcOQK/img.png"
    , contentDescription = "앤텔로프 캐니언"
    )
}

@Composable
fun CardEx(cardData: CardData){
    val placeHolder = Color(0x33000000)
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(model = cardData.imageUri,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeHolder),
                contentDescription = cardData.imageDescription
            , modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape))
            Spacer(modifier = Modifier.size(8.dp))
            Column(){
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}

@Composable
fun CheckBoxEx(){
    Row(verticalAlignment = Alignment.CenterVertically){
//        var checked = false
//        Checkbox(checked = checked,
//            onCheckedChange = {
//            checked = !checked
//        }
//        )
        val (checked, setChecked) = remember { mutableStateOf(false)}
        Checkbox(
            checked = checked,
            onCheckedChange = setChecked
        )
        Text(text = "프로그래머입니까?"
        , modifier = Modifier.clickable{
            setChecked(!checked)
            }
        )
    }
}

@Composable
fun TextFieldEx(){
    var text by remember { mutableStateOf("Tom") }
    var email by remember { mutableStateOf("")}
    Column(modifier = Modifier.padding(16.dp)){
        TextField(value = text,
            label = {
                    Text("이름")
            },
            onValueChange = {text = it})
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Hello $text")
        Spacer(modifier = Modifier.size(12.dp))
        OutlinedTextField(value = email, label = {
                                              Text("이메일")
        }, onValueChange = {email = it})
    }
}

@Composable
fun TopBarEx(name: String){
    Column{
        TopAppBar(title = { Text("TopAppBar")},
            navigationIcon = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "업 네비게이션")
                }
            },
            actions = {
                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )
        TopAppBar{
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "업 네비게이션")
            }
            Text("TopAppBar", modifier = Modifier.weight(1f))
            IconButton(onClick = {}){
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "검색"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "설정"
                )
            }
            IconButton(onClick = {}){
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "계정"
                )
            }
        }
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTheme {
        TopBarEx("Android!")
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author : String,
    val description: String
)