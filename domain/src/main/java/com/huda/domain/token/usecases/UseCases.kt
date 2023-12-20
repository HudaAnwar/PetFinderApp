package com.huda.domain.token.usecases

import com.huda.domain.token.repository.TokenRepo


class GetTokenUseCase(private val tokenRepo: TokenRepo) {
    suspend operator fun invoke() = tokenRepo.getToken()
}

