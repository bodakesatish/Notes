package com.bodakesatish.domain.model

data class Note(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val createdTimeStamp: Long = 0L,
    val updatedTimeStamp: Long = 0L,
)
