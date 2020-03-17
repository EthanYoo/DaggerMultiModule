package com.dynatic.ad

import io.reactivex.Single
import javax.inject.Inject
import kotlin.random.Random

class AdUseCase @Inject constructor(private val adRepository: AdRepository) {
    fun loadAds(): Single<List<Ad>> {
        return adRepository.loadAds().flatMap {
            Single.just(
                listOf(
                    Ad(Random(100).nextLong()),
                    Ad(Random(100).nextLong())
                )
            )
        }
    }
}