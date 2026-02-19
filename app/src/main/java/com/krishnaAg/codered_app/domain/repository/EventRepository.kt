package com.krishnaAg.codered_app.domain.repository

import com.krishnaAg.codered_app.domain.model.Event

interface EventRepository {
    suspend fun createEvent(event: Event)
    suspend fun getAllEvents(): List<Event>
    suspend fun getEventsByCity(city: String): List<Event>
    suspend fun updateVolunteerCount(eventId: String, count: Int)
    suspend fun deleteEvent(event: Event)
}
