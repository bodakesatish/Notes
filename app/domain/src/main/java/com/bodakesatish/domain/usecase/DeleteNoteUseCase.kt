package com.bodakesatish.domain.usecase

import com.bodakesatish.domain.repository.NoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int) {
        noteRepository.delete(id)
    }
}