package com.krishnaAg.codered_app.data.local.entity

import com.krishnaAg.codered_app.domain.model.BloodRequest
import com.krishnaAg.codered_app.domain.model.Donor
import com.krishnaAg.codered_app.domain.model.Event
import com.krishnaAg.codered_app.domain.model.Volunteer
import com.krishnaAg.codered_app.domain.model.user

fun BloodRequestEntity.toDomain(): BloodRequest = BloodRequest(
    id = requestId,
    bloodGroup = bloodGroup,
    city = city,
    status = status,
    assignedVolunteerId = assignedVolunteerId
)

fun BloodRequest.toEntity(createdAt: Long = System.currentTimeMillis()): BloodRequestEntity =
    BloodRequestEntity(
        requestId = id,
        bloodGroup = bloodGroup,
        city = city,
        status = status,
        createdAt = createdAt,
        synced = false,
        assignedVolunteerId = assignedVolunteerId
    )

fun VolunteerEntity.toDomain(): Volunteer = Volunteer(
    id = volunteerId,
    userId = userId,
    status = status,
    engagementScore = engagementScore
)

fun Volunteer.toEntity(): VolunteerEntity = VolunteerEntity(
    volunteerId = id,
    userId = userId,
    status = status,
    engagementScore = engagementScore
)

fun EventEntity.toDomain(): Event = Event(
    id = eventId,
    name = name,
    city = city,
    date = date,
    volunteersCount = volunteersCount
)

fun Event.toEntity(): EventEntity = EventEntity(
    eventId = id,
    name = name,
    city = city,
    date = date,
    volunteersCount = volunteersCount
)

fun DonorEntity.toDomain(): Donor = Donor(
    id = donorId,
    name = name,
    bloodGroup = bloodGroup,
    city = city,
    lastDonationDate = lastDonationDate,
    available = available
)

fun Donor.toEntity(): DonorEntity = DonorEntity(
    donorId = id,
    name = name,
    bloodGroup = bloodGroup,
    city = city,
    lastDonationDate = lastDonationDate,
    available = available
)

fun UserEntity.toDomain(): user = user(
    id = userId,
    name = name,
    email = email,
    role = role,
    city = city
)

fun user.toEntity(): UserEntity = UserEntity(
    userId = id,
    name = name,
    email = email,
    role = role,
    city = city
)
