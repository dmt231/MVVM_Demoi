package com.example.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mvvm.databinding.LayoutDetailFragmentBinding
import com.example.mvvm.room.Note
import com.example.mvvm.room.NoteDatabase


class DetailFragment : Fragment() {
    private lateinit var binding : LayoutDetailFragmentBinding
    private lateinit var noteDatabase : NoteDatabase
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutDetailFragmentBinding.inflate(inflater, container, false)
        noteDatabase = NoteDatabase.getInstance(requireContext())
        binding.back.setOnClickListener{
            back()
        }
        binding.done.setOnClickListener{
            done()
        }
        return binding.root
    }

    private fun done() {
        if(binding.editContent.text.toString().isNotEmpty() || binding.editTitle.text.toString().isNotEmpty()){
            val note = Note(binding.editTitle.text.toString(), binding.editContent.text.toString())
            noteDatabase.noteDao().insertNote(note)
            Toast.makeText(requireContext(), "Insert Success", Toast.LENGTH_SHORT).show()
        }
    }

    private fun back(){
        if(fragmentManager != null){
            fragmentManager?.popBackStack()
        }
    }
}