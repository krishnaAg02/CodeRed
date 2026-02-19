package com.krishnaAg.codered_app.data.repository

import com.krishnaAg.codered_app.data.local.dao.BloodRequestDao
import com.krishnaAg.codered_app.data.local.entity.BloodRequestEntity
import com.krishnaAg.codered_app.data.local.entity.toDomain
import com.krishnaAg.codered_app.data.remote.BloodRequestApi
import com.krishnaAg.codered_app.domain.model.BloodRequest
import com.krishnaAg.codered_app.domain.repository.RequestRepository
import java.util.UUID

class BloodRequestRepositoryImpl(
    private val dao: BloodRequestDao,
    private val api: BloodRequestApi
) : RequestRepository {

    override suspend fun createRequest(
        bloodGroup: String,
        city: String
    ) {
        dao.insertRequest(
            BloodRequestEntity(
                requestId = UUID.randomUUID().toString(),
                bloodGroup = bloodGroup,
                city = city,
                status = "PENDING",
                createdAt = System.currentTimeMillis(),
                synced = false,
                assignedVolunteerId = null
            )
        )
    }

    override suspend fun getAllRequests(): List<BloodRequest> {
        return dao.getAllRequests().map { it.toDomain() }
    }

    override suspend fun updateRequestStatus(
        requestId: String,
        status: String,
        volunteerId: String?
    ) {
        dao.updateRequestStatus(requestId, status, volunteerId)
    }

    override suspend fun syncRequests() {
        val unsynced = dao.getUnsyncedRequests()
        unsynced.forEach {
            api.sendRequest(it.toDomain())
            dao.markAsSynced(it.requestId)
        }
    }
}
