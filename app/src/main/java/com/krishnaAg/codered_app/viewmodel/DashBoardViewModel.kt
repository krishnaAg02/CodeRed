package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.ui.dashboard.DashBoardUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashBoardViewModel : ViewModel() {

    private val _state = MutableStateFlow(DashBoardUiState())
    val state: StateFlow<DashBoardUiState> = _state.asStateFlow()

    init {
        // In a real app this would call GetDashboardStatsUseCase
        viewModelScope.launch {
            delay(300) // small shimmer for UX
            _state.value = DashBoardUiState(
                openRequests = 8,
                activeVolunteers = 24,
                upcomingEvents = 3,
                availableDonors = 42
            )
        }
    }
}
