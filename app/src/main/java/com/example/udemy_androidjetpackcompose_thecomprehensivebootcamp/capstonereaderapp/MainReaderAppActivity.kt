package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.navigation.ReaderNavigation
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.ui.theme.Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainReaderAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme { 
                ReaderApp()
            }
        }
    }
}

@Composable
fun ReaderApp(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){ 
            ReaderNavigation()
        }
    }
}