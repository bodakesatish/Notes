package com.bodakesatish.data.mapper

import com.bodakesatish.data.source.local.entity.NoteEntity
import com.bodakesatish.domain.model.Note

object NoteMapper : Mapper<NoteEntity, Note> {
    override fun NoteEntity.mapToDomainModel(): Note {
        return Note(id = id, title = title, content = content)
    }

    override fun Note.mapFromDomainModel(): NoteEntity {
        return NoteEntity(id = id, title = title, content = content)
    }
}