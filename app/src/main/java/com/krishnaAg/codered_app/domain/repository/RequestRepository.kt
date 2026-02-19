package com.krishnaAg.codered_app.domain.repository

import com.krishnaAg.codered_app.domain.model.BloodRequest

interface RequestRepository {
    suspend fun createRequest(bloodGroup: String, city: String)
    suspend fun getAllRequests(): List<BloodRequest>
    suspend fun updateRequestStatus(requestId: String, status: String, volunteerId: String?)
    suspend fun syncRequests()
}
