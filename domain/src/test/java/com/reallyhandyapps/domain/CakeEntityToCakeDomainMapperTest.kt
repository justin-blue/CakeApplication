package com.reallyhandyapps.domain

import com.reallyhandyapps.data.CakeEntity
import org.junit.Before
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat



class CakeEntityToCakeDomainMapperTest {
    lateinit var mapper: CakeEntityToCakeDomainMapper

    @Before
    fun setUp() {
        mapper = CakeEntityToCakeDomainMapper()
    }

    @Test
    fun `Given a successful request, when a list of cakes is mapped, then duplicates are removed and cakes are sorted in alphabetical order`(){
        //Given
        val zebraCake = CakeEntity("zebra cake","Stripy cake","fakeURL")
        val bDayCake = CakeEntity("birthday cake","happy birthday","fakeBirthdayURL")
        val carrotCake = CakeEntity("Carrot cake","vitamin A","carrotURL")

        //When
        val result = mapper.map(listOf(carrotCake,zebraCake,zebraCake,bDayCake,bDayCake,carrotCake))

        //Then
        with(result){
            assertThat(size).isEqualTo(3)
            assertThat(get(0).title).isEqualTo("birthday cake")
            assertThat(get(1).title).isEqualTo("Carrot cake")
            assertThat(get(2).title).isEqualTo("zebra cake")
        }
    }
}