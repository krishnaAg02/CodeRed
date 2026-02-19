package com.krishnaAg.codered_app.data.remote

import com.krishnaAg.codered_app.domain.model.BloodRequest

/**
 * API interface for syncing blood requests to a backend.
 * Implement with real API when backend is available.
 */
interface BloodRequestApi {
    suspend fun sendRequest(request: BloodRequest)
}

/**
 * No-op implementation for offline-first mode.
 * Replace with real implementation when backend is ready.
 */
class BloodRequestApiNoOp : BloodRequestApi {
    override suspend fun sendRequest(request: BloodRequest) {
        // No-op: requests are stored locally only
    }
}
