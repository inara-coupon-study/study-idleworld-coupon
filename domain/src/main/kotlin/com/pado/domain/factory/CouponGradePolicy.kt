package com.pado.domain.factory

import com.pado.domain.type.CouponGrade
import org.springframework.stereotype.Service

@Service
class CouponGradePolicy {
    fun getCouponGradeCount(count: Int): List<CouponGrade> {
        val result = mutableListOf<CouponGrade>()
        val couponGradeList = CouponGrade.values().toList()

        // 각 쿠폰 종류 별 비율만큼 카운트
        for (i in couponGradeList.indices) {
            val a = count * couponGradeList[i].rate / 100
            for(j in 0 until a) {
                result.add(couponGradeList[i])
            }
        }

        // 나머지는 normal 쿠폰으로 채움
        val remain = count - result.size
        for(i in 0 until remain) {
            result.add(CouponGrade.NORMAL)
        }

        return result
    }
}