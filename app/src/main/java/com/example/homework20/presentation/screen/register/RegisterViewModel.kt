package com.example.homework20.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.presentation.event.NavigationEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val _uiEvent = MutableSharedFlow<LogInUiEvent>()
    val uiEvent: SharedFlow<LogInUiEvent> get() = _uiEvent

    fun onEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.NavigateToLogin -> toLogin()
            else -> println()
        }
    }

    private fun toLogin(){
        viewModelScope.launch {
            _uiEvent.emit(LogInUiEvent.NavigateToLogin)
        }
    }

    sealed interface LogInUiEvent {
        data object NavigateToLogin : LogInUiEvent
    }
}