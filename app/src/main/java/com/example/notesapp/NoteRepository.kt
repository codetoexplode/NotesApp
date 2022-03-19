package com.example.notesapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao:NoteDAO) {
   val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}