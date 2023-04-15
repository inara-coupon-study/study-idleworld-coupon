package com.pado.domain.factory

import com.pado.domain.entity.Coupon
import com.pado.domain.entity.CouponMetaInfo
import com.pado.domain.type.CouponGrade
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class CouponFactory {
    fun createCouponCode(metaInfo: CouponMetaInfo, couponGrade: CouponGrade): Coupon {
        return Coupon(
            code = generateRandomNumber(),
            metaInfo = metaInfo.of(couponGrade = couponGrade)
        )
    }

    private fun generateRandomNumber(): String {
        return RandomStringUtils.randomAlphanumeric(10).uppercase(Locale.getDefault())
    }
}