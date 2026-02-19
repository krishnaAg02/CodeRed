package com.krishnaAg.codered_app.domain.repository

import com.krishnaAg.codered_app.domain.model.Donor

interface DonorRepository {
    suspend fun addDonor(donor: Donor)
    suspend fun findAvailableDonors(bloodGroup: String, city: String): List<Donor>
    suspend fun updateAvailability(id: String, available: Boolean)
    suspend fun getAllDonors(): List<Donor>
    suspend fun deleteDonor(donor: Donor)
}
