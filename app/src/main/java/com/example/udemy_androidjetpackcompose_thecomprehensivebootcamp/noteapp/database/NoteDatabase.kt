package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.dao.NoteDao
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.model.Note
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.utils.DateConverter
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.utils.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao(): NoteDao
}