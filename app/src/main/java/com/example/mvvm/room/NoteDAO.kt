package com.example.mvvm.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNote() : LiveData<List<Note>>

    @Delete

    fun delete(note: Note)
}