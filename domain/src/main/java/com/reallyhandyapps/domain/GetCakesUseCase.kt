package com.reallyhandyapps.domain

import com.reallyhandyapps.data.DomainResult
import com.reallyhandyapps.data.services.GetCakesRepository
import javax.inject.Inject

class GetCakesUseCase @Inject constructor(
    private val cakeDomainMapper: CakeEntityToCakeDomainMapper,
    private val getCakesRepository: GetCakesRepository
) {
    suspend operator fun invoke(): List<CakeDomain> {
        return when (val result = getCakesRepository.getCakes()) {
            is DomainResult.Success -> cakeDomainMapper.map(result.data)
            is DomainResult.Error -> emptyList()
        }
    }
}