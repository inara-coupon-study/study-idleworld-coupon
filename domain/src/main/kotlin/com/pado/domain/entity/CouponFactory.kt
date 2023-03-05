package com.pado.domain.entity

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class CouponFactory {
    fun createCouponCode(title: String, reward: String): Coupon {
        return Coupon(
            code = generateRandomNumber(),
            title = title,
            reward = reward
        )
    }

    private fun generateRandomNumber(): String {
        return RandomStringUtils.randomAlphanumeric(10).uppercase(Locale.getDefault())
    }
}