package com.example.mvvm.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.repository.NoteRepository
import com.example.mvvm.room.Note

class NoteViewModel() : ViewModel() {
    private lateinit var noteRepository: NoteRepository
    private lateinit var liveDataNote: LiveData<List<Note>>

    fun getLiveDataNote(context: Context): LiveData<List<Note>> {
        noteRepository = NoteRepository()
        liveDataNote = noteRepository.getAllNote(context)
        return liveDataNote
    }
}
