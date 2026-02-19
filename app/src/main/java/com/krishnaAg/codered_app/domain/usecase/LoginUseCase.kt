package com.krishnaAg.codered_app.domain.usecase

class LoginUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: String) =
        userRepository.getUserById(userId)
}
