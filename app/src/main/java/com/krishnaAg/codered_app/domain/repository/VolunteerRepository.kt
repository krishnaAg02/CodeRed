package com.krishnaAg.codered_app.domain.repository

import com.krishnaAg.codered_app.domain.model.Volunteer

interface VolunteerRepository {
    suspend fun addVolunteer(volunteer: Volunteer)
    suspend fun getAllVolunteers(): List<Volunteer>
    suspend fun getVolunteersByStatus(status: String): List<Volunteer>
    suspend fun updateVolunteerStatus(id: String, status: String)
    suspend fun deleteVolunteer(volunteer: Volunteer)
}
