package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.data.NotesDataSource
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.model.Note
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel @Inject constructor(private val repository: NoteRepository) :ViewModel() {
//    var noteList = mutableStateListOf<Note>()
    
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
    
    init {
        viewModelScope.launch ( Dispatchers.IO ){
            repository.getAllNotes().distinctUntilChanged().collect{listOfNotes->
                if(listOfNotes.isEmpty()){
                    Log.d("Empty", ": Empty List")
                }else{
                    _noteList.value = listOfNotes
                }
            }
        }
    }
    
    fun addNote(note:Note) = viewModelScope.launch { repository.addNote(note)}
    fun updateNote(note:Note) = viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note:Note) = viewModelScope.launch { repository.deleteNote(note) }
    
    
}