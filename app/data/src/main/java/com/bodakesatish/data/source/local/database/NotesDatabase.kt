package com.bodakesatish.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bodakesatish.data.source.local.dao.NoteDao
import com.bodakesatish.data.source.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}