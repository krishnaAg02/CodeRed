package com.krishnaAg.codered_app.data.repository

import com.krishnaAg.codered_app.data.local.dao.DonorDao
import com.krishnaAg.codered_app.data.local.entity.toDomain
import com.krishnaAg.codered_app.data.local.entity.toEntity
import com.krishnaAg.codered_app.domain.model.Donor
import com.krishnaAg.codered_app.domain.repository.DonorRepository

class DonorRepositoryImpl(
    private val donorDao: DonorDao
) : DonorRepository {

    override suspend fun addDonor(donor: Donor) {
        donorDao.insertDonor(donor.toEntity())
    }

    override suspend fun findAvailableDonors(
        bloodGroup: String,
        city: String
    ): List<Donor> {
        return donorDao.findAvailableDonors(bloodGroup, city)
            .map { it.toDomain() }
    }

    override suspend fun updateAvailability(id: String, available: Boolean) {
        donorDao.updateAvailability(id, available)
    }

    override suspend fun getAllDonors(): List<Donor> {
        return donorDao.getAllDonors().map { it.toDomain() }
    }

    override suspend fun deleteDonor(donor: Donor) {
        donorDao.deleteDonor(donor.toEntity())
    }
}
