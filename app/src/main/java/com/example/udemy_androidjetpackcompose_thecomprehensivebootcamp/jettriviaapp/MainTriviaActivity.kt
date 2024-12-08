package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.screens.QuestionsViewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.screens.TriviaHome
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.ui.theme.Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainTriviaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {
                Surface {
                    TriviaHome()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {

    }
}