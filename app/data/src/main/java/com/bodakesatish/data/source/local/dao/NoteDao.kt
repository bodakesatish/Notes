package com.bodakesatish.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bodakesatish.data.source.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(customerEntity: NoteEntity): Long

    @Update
    suspend fun update(customerEntity: NoteEntity): Int

    @Query("DELETE FROM ${NoteEntity.TABLE_NAME} WHERE ${NoteEntity.Columns.ID} = :id")
    fun delete(id: Int)

    @Query("SELECT * FROM ${NoteEntity.TABLE_NAME}")
    fun getNotes(): Flow<List<NoteEntity>>

}