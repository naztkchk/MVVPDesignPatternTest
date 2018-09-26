package com.tkachuk.mvvpdesignpatterntest

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(

        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val title: String,
        val description: String,
        val priority: Int
)