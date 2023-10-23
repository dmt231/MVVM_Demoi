package com.example.mvvm.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.util.splitToIntList


@Entity(tableName = "Note")
class Note {
    @PrimaryKey(autoGenerate = true)
    private var id: Int? = 0
    private var title : String? = null
    private var content : String? = null

    fun getId(): Int {
        return id!!
    }

    fun setId(id: Int) {
        this.id = id
    }


    fun getTitle() : String{
        return title!!
    }
    fun getContent() : String{
        return content!!
    }
    constructor(title : String, content : String){
        this.content = content
        this.title = title
    }
}