package com.reallyhandyapps.domain

import com.reallyhandyapps.data.CakeEntity
import com.reallyhandyapps.data.Mapper
import javax.inject.Inject

class CakeEntityToCakeDomainMapper @Inject constructor() :
    Mapper<List<CakeEntity>, List<CakeDomain>> {
    override fun map(from: List<CakeEntity>): List<CakeDomain> {
        return from.map {
            CakeDomain(
                title = it.title,
                desc = it.desc,
                imageURL = it.image
            )
        }
            .distinct()
            .sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.title })
    }
}