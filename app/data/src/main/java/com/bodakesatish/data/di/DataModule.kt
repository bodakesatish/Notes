package com.bodakesatish.data.di

import com.bodakesatish.data.repository.NoteRepositoryImpl
import com.bodakesatish.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface  DataModule {

    @Binds
    @Singleton
    fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

}