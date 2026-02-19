package com.krishnaAg.codered_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krishnaAg.codered_app.data.local.entity.BloodRequestEntity

@Dao
interface BloodRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRequest(request: BloodRequestEntity)

    @Query("SELECT * FROM blood_requests ORDER BY createdAt DESC")
    suspend fun getAllRequests(): List<BloodRequestEntity>

    @Query("""
        SELECT * FROM blood_requests 
        WHERE status = :status
        ORDER BY createdAt DESC
    """)
    suspend fun getRequestsByStatus(status: String): List<BloodRequestEntity>

    @Query("SELECT * FROM blood_requests WHERE synced = 0")
    suspend fun getUnsyncedRequests(): List<BloodRequestEntity>

    @Query("UPDATE blood_requests SET synced = 1 WHERE requestId = :id")
    suspend fun markAsSynced(id: String)

    @Query("""
        UPDATE blood_requests 
        SET status = :status, assignedVolunteerId = :volunteerId 
        WHERE requestId = :id
    """)
    suspend fun updateRequestStatus(
        id: String,
        status: String,
        volunteerId: String?
    )

    @Delete
    suspend fun deleteRequest(request: BloodRequestEntity)
}
