package com.pado.domain.type

enum class ExpiredPeriodUnit{
    MONTH,
    WEEK,
    DATE;

    companion object {
        fun of(name: String): ExpiredPeriodUnit {
            return ExpiredPeriodUnit.values().firstOrNull() { it.name == name }
                ?: throw RuntimeException("CategoryStatus 구분을 찾을 수 없습니다.")
        }
    }
}