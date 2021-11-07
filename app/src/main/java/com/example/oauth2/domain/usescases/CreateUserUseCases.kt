package com.example.oauth2.domain.usescases

import com.example.oauth2.domain.repositories.AuthRepository
import javax.inject.Inject

class CreateUserUseCases @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke(username: String, pass: String) = repository.createUser(username, pass)
}