package com.bodakesatish.ui.notes

import com.bodakesatish.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false
)