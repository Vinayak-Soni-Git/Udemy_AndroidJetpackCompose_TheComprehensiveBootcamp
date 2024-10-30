package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.repository

import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.dao.NoteDao
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun addNote(note:Note) = noteDao.insert(note)
    suspend fun updateNote(note:Note) = noteDao.update(note)
    suspend fun deleteNote(note:Note) = noteDao.deleteNote(note)
    suspend fun deleteAllNotes() = noteDao.deleteAll()
    suspend fun getAllNotes():Flow<List<Note>> = noteDao.getNotes().flowOn(Dispatchers.IO).conflate()
}