package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.noteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),
    
    @ColumnInfo(name = "title")
    val title:String,
    
    @ColumnInfo(name = "description")
    val description:String,
    
    @ColumnInfo(name = "entryDate")
    val entryDate:Date = Date.from(Instant.now())
)
