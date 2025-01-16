package com.bodakesatish.domain.repository

import com.bodakesatish.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertOrUpdate(customer: Note): Long
    suspend fun delete(id: Int)
    fun getNotes(): Flow<List<Note>>
}