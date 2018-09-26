package com.tkachuk.mvvpdesignpatterntest

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {

        var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database")
                        .fallbackToDestructiveMigration()
                        .build()
            }

            return instance as NoteDatabase
        }
    }

}