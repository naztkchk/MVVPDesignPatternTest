package com.tkachuk.mvvpdesignpatterntest

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import org.jetbrains.annotations.NotNull

class NoteViewModel(@NotNull application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application)
    private val allNotes = noteRepository.getAllNotes()

    fun insert(note: Note) {
        noteRepository.insert(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }

    fun deleteAllNotes() {
        noteRepository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }
}