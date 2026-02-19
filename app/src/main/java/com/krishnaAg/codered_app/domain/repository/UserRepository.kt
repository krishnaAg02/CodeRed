package com.krishnaAg.codered_app.domain.repository

import com.krishnaAg.codered_app.domain.model.user

interface UserRepository {
    suspend fun insertUser(user: user)
    suspend fun getUserById(userId: String): user?
    suspend fun getAllUsers(): List<user>
    suspend fun deleteUser(user: user)
}
