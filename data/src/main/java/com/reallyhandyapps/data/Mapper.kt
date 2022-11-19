package com.reallyhandyapps.data

interface Mapper<From,To> {
    fun map(from:From): To
}