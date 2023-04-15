package com.pado.domain.type

enum class CouponGrade(val rate: Int) {
    NORMAL(50),
    RARE(30),
    UNIQUE(15),
    UNICORN(5); // 50 30 15 5


    companion object {
        fun of(name: String): CouponGrade {
            return CouponGrade.values().firstOrNull() { it.name == name }
                ?: throw RuntimeException("CategoryStatus 구분을 찾을 수 없습니다.")
        }
    }
}