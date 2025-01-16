package com.bodakesatish.domain.usecase

import com.bodakesatish.domain.model.Note
import com.bodakesatish.domain.repository.NoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddOrUpdateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
)  {
    suspend operator fun invoke(note: Note): Long {
       return noteRepository.insertOrUpdate(note)
    }
}