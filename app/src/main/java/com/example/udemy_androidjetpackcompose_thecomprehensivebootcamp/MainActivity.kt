package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.bizcardapp.BizCardApp
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.ui.theme.Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetButtons()
                }
            }
        }
    }
}

@Composable
private fun SetButtons(){
    val context = LocalContext.current
    val buttonShape = RoundedCornerShape(
        topStart = 2.dp,
        topEnd = 2.dp,
        bottomStart = 2.dp,
        bottomEnd = 2.dp
    )
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.White,
        contentColor = Color.Black
    )
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { 
            val openBizCardApp = Intent(context, BizCardApp::class.java)
            context.startActivity(openBizCardApp)
        }, colors = buttonColors, shape = buttonShape, modifier = Modifier.fillMaxWidth()) {
            Text(text = "BizCard App")
        }
    }
}

@Preview
@Composable
fun MainActivityPreview(){
    SetButtons()
}