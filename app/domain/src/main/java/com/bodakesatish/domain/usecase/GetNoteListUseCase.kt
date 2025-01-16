package com.bodakesatish.domain.usecase

import com.bodakesatish.domain.repository.NoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNoteListUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke() = noteRepository.getNotes()
}