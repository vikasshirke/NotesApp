package com.dtt.notesapp.repository

import com.dtt.notesapp.data.dao.NoteDao
import com.dtt.notesapp.data.entity.Note


class NoteRepository(private val noteDao: NoteDao) {
    val allNotes = noteDao.getAllNotes()

    suspend fun insert(note: Note) = noteDao.insert(note)
    suspend fun update(note: Note) = noteDao.update(note)
    suspend fun delete(note: Note) = noteDao.delete(note)
}
