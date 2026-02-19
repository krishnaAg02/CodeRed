package com.krishnaAg.codered_app

import android.app.Application
import com.krishnaAg.codered_app.data.local.AppDatabase
import com.krishnaAg.codered_app.data.remote.BloodRequestApiNoOp
import com.krishnaAg.codered_app.data.repository.BloodRequestRepositoryImpl
import com.krishnaAg.codered_app.data.repository.DonorRepositoryImpl
import com.krishnaAg.codered_app.data.repository.EventRepositoryImpl
import com.krishnaAg.codered_app.data.repository.UserRepositoryImpl
import com.krishnaAg.codered_app.data.repository.VolunteerRepositoryImpl
import com.krishnaAg.codered_app.domain.repository.DonorRepository
import com.krishnaAg.codered_app.domain.repository.EventRepository
import com.krishnaAg.codered_app.domain.repository.RequestRepository
import com.krishnaAg.codered_app.domain.repository.UserRepository
import com.krishnaAg.codered_app.domain.repository.VolunteerRepository

class CodeRedApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }

    val requestRepository: RequestRepository by lazy {
        BloodRequestRepositoryImpl(
            dao = database.bloodRequestDao(),
            api = BloodRequestApiNoOp()
        )
    }

    val userRepository: UserRepository by lazy {
        UserRepositoryImpl(database.userDao())
    }

    val volunteerRepository: VolunteerRepository by lazy {
        VolunteerRepositoryImpl(database.volunteerDao())
    }

    val eventRepository: EventRepository by lazy {
        EventRepositoryImpl(database.eventDao())
    }

    val donorRepository: DonorRepository by lazy {
        DonorRepositoryImpl(database.donorDao())
    }
}
