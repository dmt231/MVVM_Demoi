package com.example.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.room.Note
import com.example.mvvm.room.NoteDatabase

class NoteRepository {
    fun getAllNote(context : Context) : LiveData<List<Note>> {
        return NoteDatabase.getInstance(context).noteDao().getAllNote()
    }
}
