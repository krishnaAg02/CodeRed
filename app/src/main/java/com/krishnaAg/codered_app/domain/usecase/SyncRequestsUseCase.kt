package com.krishnaAg.codered_app.domain.usecase

import com.krishnaAg.codered_app.domain.repository.RequestRepository


class SyncRequestsUseCase(
    private val repository: RequestRepository
) {
    suspend operator fun invoke() {
        repository.syncRequests()
    }
}
