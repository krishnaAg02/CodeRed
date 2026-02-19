package com.krishnaAg.codered_app.domain.usecase

import com.krishnaAg.codered_app.domain.repository.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: String) =
        userRepository.getUserById(userId)
}
