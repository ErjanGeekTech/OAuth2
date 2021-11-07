package com.example.oauth2.domain.usescases

import com.example.oauth2.domain.repositories.AuthorizeRepository
import javax.inject.Inject

class AuthorizeUseCases @Inject constructor(private val repository: AuthorizeRepository) {

    operator fun invoke() = repository.fetchAuthorize()
}