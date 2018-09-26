package com.tkachuk.mvvpdesignpatterntest

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class NoteRepository(application: Application) {

    private val noteDao = NoteDatabase.getInstance(application).noteDao
    private val allNotes: LiveData<List<Note>>

    init {
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun update(note: Note) {
        UpdateNoteAsyncTask(noteDao).execute(note)
    }

    fun delete(note: Note) {
        DeleteNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(noteDao).execute()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg p0: Note): Void? {
            noteDao.insert(p0[0])
            return null
        }
    }

    private class UpdateNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg p0: Note): Void? {
            noteDao.update(p0[0])
            return null
        }
    }

    private class DeleteNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg p0: Note): Void? {
            noteDao.delete(p0[0])
            return null
        }
    }

    private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg p0: Void?): Void? {
            noteDao.deleteAllNotes()
            return null
        }
    }
}