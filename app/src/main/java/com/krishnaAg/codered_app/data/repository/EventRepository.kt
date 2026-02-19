package com.krishnaAg.codered_app.data.repository

import com.krishnaAg.codered_app.data.local.dao.EventDao
import com.krishnaAg.codered_app.data.local.entity.toDomain
import com.krishnaAg.codered_app.data.local.entity.toEntity
import com.krishnaAg.codered_app.domain.model.Event
import com.krishnaAg.codered_app.domain.repository.EventRepository

class EventRepositoryImpl(
    private val eventDao: EventDao
) : EventRepository {

    override suspend fun createEvent(event: Event) {
        eventDao.insertEvent(event.toEntity())
    }

    override suspend fun getAllEvents(): List<Event> {
        return eventDao.getAllEvents().map { it.toDomain() }
    }

    override suspend fun getEventsByCity(city: String): List<Event> {
        return eventDao.getEventsByCity(city).map { it.toDomain() }
    }

    override suspend fun updateVolunteerCount(eventId: String, count: Int) {
        eventDao.updateVolunteerCount(eventId, count)
    }

    override suspend fun deleteEvent(event: Event) {
        eventDao.deleteEvent(event.toEntity())
    }
}
