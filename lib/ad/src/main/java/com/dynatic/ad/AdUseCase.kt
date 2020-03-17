package com.dynatic.ad

import io.reactivex.Single
import kotlin.random.Random

class AdUseCase(private val adRepositoryImpl: AdRepository) {
    fun loadAds(): Single<List<Ad>> {
        return adRepositoryImpl.loadAds().flatMap {
            Single.just(
                listOf(
                    Ad(Random(100).nextLong()),
                    Ad(Random(100).nextLong())
                )
            )
        }
    }
}