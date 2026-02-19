package com.krishnaAg.codered_app.domain.usecase

import com.krishnaAg.codered_app.domain.repository.RequestRepository

class CreateBloodRequestUseCase(
    private val repository: RequestRepository
) {
    suspend operator fun invoke(
        bloodGroup: String,
        city: String
    ) {
        repository.createRequest(bloodGroup, city)
    }
}
