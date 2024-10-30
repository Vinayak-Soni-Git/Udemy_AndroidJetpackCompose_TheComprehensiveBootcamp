package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.data.NotesDataSource
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.model.Note
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.screen.NoteScreen
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.viewmodel.NoteViewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.ui.theme.Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainNoteAppActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
//                    val noteViewModel = viewModel<NoteViewModel>() // also works
                    val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel:NoteViewModel){
    val notesList = noteViewModel.noteList.collectAsState().value
    
    NoteScreen(notes = notesList, onAddNote = {
        noteViewModel.addNote(it)
    }, onRemoveNote = {
        noteViewModel.removeNote(it)
        
    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {
        
    }
}