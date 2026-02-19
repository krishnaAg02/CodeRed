package com.krishnaAg.codered_app.ui.donor

import com.krishnaAg.codered_app.domain.model.Donor

data class DonorUiState(
    val isLoading: Boolean = false,
    val donors: List<Donor> = emptyList(),
    val errorMessage: String? = null
)
