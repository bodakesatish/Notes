package com.bodakesatish.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NoteEntity.TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(Columns.ID)
    val id: Int = 0,
    @ColumnInfo(Columns.TITLE)
    val title: String,
    @ColumnInfo(Columns.CONTENT)
    val content: String
) {

    companion object {
        const val TABLE_NAME = "notes"
    }

    internal object Columns {
        internal const val ID = "id"
        internal const val TITLE = "title"
        internal const val CONTENT = "content"
    }

}