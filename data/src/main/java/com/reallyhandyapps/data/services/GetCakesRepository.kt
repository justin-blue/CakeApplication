package com.reallyhandyapps.data.services

import com.reallyhandyapps.data.DomainResult
import com.reallyhandyapps.data.ApiResponseMapper
import com.reallyhandyapps.data.CakeEntity
import javax.inject.Inject

class GetCakesRepository @Inject constructor(
    private val getCakesService: GetCakesService
) : ApiResponseMapper() {
    suspend fun getCakes(): DomainResult<List<CakeEntity>>{
      return  call(getCakesService.getCakesAsync())
    }
}