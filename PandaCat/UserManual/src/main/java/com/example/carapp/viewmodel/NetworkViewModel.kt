package com.example.carapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carapp.network.IoDispatcher
import com.example.carapp.network.MainDispatcher
import com.example.carapp.network.modelcase.GetUserManualCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val getUserManualCase: GetUserManualCase
): ViewModel() {

    private val _jsonReleaseNotes = MutableStateFlow<String>("")

    val jsonReleaseNotes: Flow<String> = _jsonReleaseNotes

    init {
        getReleaseNotes("")
    }

    private fun getReleaseNotes(
        version: String
    ) {
        viewModelScope.launch(ioDispatcher) {
            val jsonReleaseNotes = getUserManualCase.invoke(
                version = version
            )
            withContext(mainDispatcher) {
                _jsonReleaseNotes.emit(jsonReleaseNotes)
            }
        }
    }
}