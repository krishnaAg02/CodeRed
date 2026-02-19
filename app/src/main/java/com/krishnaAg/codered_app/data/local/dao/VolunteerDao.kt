package com.krishnaAg.codered_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krishnaAg.codered_app.data.local.entity.VolunteerEntity

@Dao
interface VolunteerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVolunteer(volunteer: VolunteerEntity)

    @Query("SELECT * FROM VolunteerEntity")
    suspend fun getAllVolunteers(): List<VolunteerEntity>

    @Query("SELECT * FROM VolunteerEntity WHERE status = :status")
    suspend fun getVolunteersByStatus(status: String): List<VolunteerEntity>

    @Query("UPDATE VolunteerEntity SET status = :status WHERE volunteerId = :id")
    suspend fun updateStatus(id: String, status: String)

    @Delete
    suspend fun deleteVolunteer(volunteer: VolunteerEntity)
}
