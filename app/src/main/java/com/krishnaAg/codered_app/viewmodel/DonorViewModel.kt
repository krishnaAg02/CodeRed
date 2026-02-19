package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.domain.model.Donor
import com.krishnaAg.codered_app.ui.donor.DonorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DonorViewModel : ViewModel() {

    private val _state = MutableStateFlow(DonorUiState())
    val state: StateFlow<DonorUiState> = _state.asStateFlow()

    init {
        loadDonors()
    }

    private fun loadDonors() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Simulating API call
            val sampleDonors = listOf(
                Donor("1", "John Doe", "O+", "Mumbai", System.currentTimeMillis() - 10000000000, true),
                Donor("2", "Jane Smith", "A-", "Delhi", System.currentTimeMillis() - 5000000000, false),
                Donor("3", "Bob Wilson", "B+", "Bangalore", System.currentTimeMillis() - 20000000000, true)
            )
            _state.value = _state.value.copy(
                isLoading = false,
                donors = sampleDonors
            )
        }
    }
}
