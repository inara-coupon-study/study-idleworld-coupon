package com.pado.domain.type

enum class CouponGrade {
    NORMAL, RARE, UNIQUE, UNICORN;


    companion object {
        fun of(name: String): CouponGrade {
            return CouponGrade.values().firstOrNull() { it.name == name }
                ?: throw RuntimeException("CategoryStatus 구분을 찾을 수 없습니다.")
        }
    }
}