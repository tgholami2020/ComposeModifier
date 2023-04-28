package com.example.usingcomposemodifiers

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.colorspace.ColorModel
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.usingcomposemodifiers.ui.theme.UsingComposeModifiersTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsingComposeModifiersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNote()
                }
            }
        }
    }
}
@Composable
fun MyNote(){
    LazyColumn(){
        items((1..20).toList()){
            Note()
        }
    }
}
@Composable
fun Note(){
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    Row(modifier = Modifier                  //giving background to Note
        .padding(8.dp)
        .shadow(1.dp, backgroundShape)
        .fillMaxWidth()
        .heightIn(min = 4.dp)
        .background(Color.White, backgroundShape)
        ) {
            NoteColor(                          //instead of box use NoteColor
                modifier= Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 16.dp),
                color = Color.Red,
                size = 40.dp,
                border = 1.dp,
            )
        
        Column(modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterVertically)               //centering te Text
            ) {
            Text(
                text = "Title",
                maxLines = 1,
                color = Color.Black,
                style = TextStyle(                           //styling the text
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp)
                )
            Text(
                text = "Content",
                color=Color.Black.copy(alpha = 0.75f),
                maxLines = 1,
                style = TextStyle(                           //styling the text
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp
                )
                )
        }
         Checkbox(
             checked = false,
             onCheckedChange ={},
             modifier = Modifier
                 .padding(8.dp)
                 .align(Alignment.CenterVertically)
         )
    }
}

@Composable
fun NoteColor(
    modifier: Modifier=Modifier,
    color:Color,
    size: Dp,
    border:Dp
) {
    Box(modifier = modifier
        .size(size)
        //.padding(padding)
        .clip(CircleShape)
        .background(color)
        .border(
            BorderStroke(border, SolidColor(Color.Black)),
            CircleShape
        )
        ) {
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UsingComposeModifiersTheme {
       Note()
    }
}