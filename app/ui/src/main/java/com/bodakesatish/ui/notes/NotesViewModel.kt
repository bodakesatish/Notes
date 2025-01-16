package com.bodakesatish.ui.notes

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.domain.model.Note
import com.bodakesatish.domain.usecase.AddOrUpdateNoteUseCase
import com.bodakesatish.domain.usecase.GetNoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getCustomerListUseCase: GetNoteListUseCase,
    private val addNote: AddOrUpdateNoteUseCase
) : ViewModel() {

    private val tag = this.javaClass.simpleName

    private val _customerList = MutableStateFlow<List<Note>>(emptyList())
    val customers: StateFlow<List<Note>> = _customerList.asStateFlow()

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    init {
        addNotes()
        Log.d(tag, "$tag->init")
        getNoteList()
    }

    fun addNotes() {
        viewModelScope.launch(Dispatchers.IO)  {
            val id =    addNote(Note(1, "Satish", "Bodake"))
            Log.d(tag, "In $tag $id")
        }
    }

    fun getNoteList() {
        Log.d(tag, "$tag->getCustomerList")
        viewModelScope.launch(Dispatchers.IO) {
            getCustomerListUseCase.invoke().onEach { notes: List<Note> ->
                _state.value = state.value.copy(
                    notes = notes,
                    isLoading = false
                )
            }.launchIn(viewModelScope)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(tag, "$tag->onCleared")
    }


}