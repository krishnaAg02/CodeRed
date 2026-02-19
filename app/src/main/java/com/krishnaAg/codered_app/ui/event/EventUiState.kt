package com.krishnaAg.codered_app.ui.event

import com.krishnaAg.codered_app.domain.model.Event

data class EventUiState(
    val isLoading: Boolean = false,
    val events: List<Event> = emptyList(),
    val errorMessage: String? = null
)
