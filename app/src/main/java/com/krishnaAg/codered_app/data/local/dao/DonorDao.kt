package com.krishnaAg.codered_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krishnaAg.codered_app.data.local.entity.DonorEntity

@Dao
interface DonorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonor(donor: DonorEntity)

    @Query("""
        SELECT * FROM DonorEntity 
        WHERE bloodGroup = :bloodGroup 
        AND city = :city 
        AND available = 1
    """)
    suspend fun findAvailableDonors(
        bloodGroup: String,
        city: String
    ): List<DonorEntity>

    @Query("UPDATE DonorEntity SET available = :available WHERE donorId = :id")
    suspend fun updateAvailability(id: String, available: Boolean)

    @Query("SELECT * FROM DonorEntity")
    suspend fun getAllDonors(): List<DonorEntity>

    @Delete
    suspend fun deleteDonor(donor: DonorEntity)
}
