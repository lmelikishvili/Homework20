package com.example.homework20.presentation.event

sealed class NavigationEvent{
    data object NavigateToLogin: NavigationEvent()
    data object NavigateToRegister: NavigationEvent()
}
