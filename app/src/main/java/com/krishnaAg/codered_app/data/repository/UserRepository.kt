package com.krishnaAg.codered_app.data.repository

import com.krishnaAg.codered_app.data.local.dao.UserDao
import com.krishnaAg.codered_app.data.local.entity.toDomain
import com.krishnaAg.codered_app.data.local.entity.toEntity
import com.krishnaAg.codered_app.domain.model.user
import com.krishnaAg.codered_app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toEntity())
    }

    override suspend fun getUserById(userId: String): User? {
        return userDao.getUserById(userId)?.toDomain()
    }

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers().map { it.toDomain() }
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.toEntity())
    }
}
