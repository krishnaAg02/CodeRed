package com.krishnaAg.codered_app.data.repository

import com.krishnaAg.codered_app.data.local.dao.VolunteerDao
import com.krishnaAg.codered_app.data.local.entity.toDomain
import com.krishnaAg.codered_app.data.local.entity.toEntity
import com.krishnaAg.codered_app.domain.model.Volunteer
import com.krishnaAg.codered_app.domain.repository.VolunteerRepository

class VolunteerRepositoryImpl(
    private val volunteerDao: VolunteerDao
) : VolunteerRepository {

    override suspend fun addVolunteer(volunteer: Volunteer) {
        volunteerDao.insertVolunteer(volunteer.toEntity())
    }

    override suspend fun getAllVolunteers(): List<Volunteer> {
        return volunteerDao.getAllVolunteers().map { it.toDomain() }
    }

    override suspend fun getVolunteersByStatus(status: String): List<Volunteer> {
        return volunteerDao.getVolunteersByStatus(status).map { it.toDomain() }
    }

    override suspend fun updateVolunteerStatus(id: String, status: String) {
        volunteerDao.updateStatus(id, status)
    }

    override suspend fun deleteVolunteer(volunteer: Volunteer) {
        volunteerDao.deleteVolunteer(volunteer.toEntity())
    }
}
