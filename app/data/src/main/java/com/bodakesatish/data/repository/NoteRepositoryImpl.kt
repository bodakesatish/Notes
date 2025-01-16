package com.bodakesatish.data.repository

import com.bodakesatish.data.mapper.NoteMapper.mapFromDomainModel
import com.bodakesatish.data.mapper.NoteMapper.mapToDomainModel
import com.bodakesatish.data.source.local.dao.NoteDao
import com.bodakesatish.domain.model.Note
import com.bodakesatish.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun insertOrUpdate(customer: Note): Long {
        return noteDao.insertOrUpdate(customer.mapFromDomainModel())
    }

    override suspend fun delete(id: Int) {
        return noteDao.delete(id)
    }

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
            .map { customers ->
                customers.map { customer ->
                    customer.mapToDomainModel()
                }
            }

    }

}