package com.bodakesatish.data.di

import android.content.Context
import androidx.room.Room
import com.bodakesatish.data.source.local.database.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val  DATABASE_NAME = "notes.db"

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext appContext: Context): NotesDatabase {
        return Room.databaseBuilder(
            appContext,
            NotesDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun providesCustomerDao(database: NotesDatabase) = database.noteDao()

}