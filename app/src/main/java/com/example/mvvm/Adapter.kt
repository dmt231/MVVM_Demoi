package com.example.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.LayoutRecyclerBinding
import com.example.mvvm.room.Note

class Adapter(listNote : ArrayList<Note>) : RecyclerView.Adapter<ViewHolder>() {
    private var listNote: List<Note>
    init {
        this.listNote = listNote
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = LayoutRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var model = listNote[position]
        holder.binding.note = model
    }

}
class ViewHolder(binding : LayoutRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
    var binding : LayoutRecyclerBinding
    init {
        this.binding = binding
    }
}