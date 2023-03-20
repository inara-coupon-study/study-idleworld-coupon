package com.pado.domain.type

enum class ExpiredPeriod{
    YEAR_1,
    MONTH_3,
    MONTH_1,
    WEEK_1,
    WEEK_2,
    DATE_3,
    DATE_1;

    companion object {
        fun of(name: String): ExpiredPeriod {
            return ExpiredPeriod.values().firstOrNull() { it.name == name }
                ?: throw RuntimeException("CategoryStatus 구분을 찾을 수 없습니다.")
        }
    }
}