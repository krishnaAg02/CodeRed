package com.krishnaAg.codered_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krishnaAg.codered_app.data.local.entity.EventEntity

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: EventEntity)

    @Query("SELECT * FROM EventEntity ORDER BY date DESC")
    suspend fun getAllEvents(): List<EventEntity>

    @Query("SELECT * FROM EventEntity WHERE city = :city")
    suspend fun getEventsByCity(city: String): List<EventEntity>

    @Query("""
        UPDATE EventEntity 
        SET volunteersCount = :count 
        WHERE eventId = :id
    """)
    suspend fun updateVolunteerCount(id: String, count: Int)

    @Delete
    suspend fun deleteEvent(event: EventEntity)
}
