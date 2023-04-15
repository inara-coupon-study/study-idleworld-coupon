package com.pado.domain.factory

import com.pado.domain.type.CouponGrade
import org.springframework.stereotype.Service

@Service
class CouponGradePolicy {
    fun getCouponGradeCount(count: Int): List<CouponGrade> {
        val result = mutableListOf<CouponGrade>()
        val couponGradeList = CouponGrade.values().toList()

        // 각 쿠폰 종류 별 비율 만큼 카운트
        couponGradeList.forEach { couponGrade ->
            repeat(count * couponGrade.rate / 100) { result.add(couponGrade) }
        }

        // 나머지는 normal 쿠폰으로 채움
        repeat(count - result.size) { result.add(CouponGrade.NORMAL) }

        return result
    }
}