package com.pado.domain.service

import com.pado.domain.dto.CouponMetaInfoDto
import com.pado.domain.entity.Coupon
import com.pado.domain.factory.CouponFactory
import com.pado.domain.repository.CouponRepository
import org.springframework.stereotype.Service


/**
    DTO를 ENTITY로 변환하는 레이어, DB 저장 끝단이다.
 */

@Service
class CouponCommandService(
    private val couponRepository: CouponRepository<Any?, Any?>,
    private val couponFactory: CouponFactory,
) {
    fun create(couponMetaInfoDto: CouponMetaInfoDto, count: Int){
        for (i in 1..count) couponRepository.save(createCoupon(metaInfo = couponMetaInfoDto))
    }

    private fun createCoupon(metaInfo: CouponMetaInfoDto): Coupon {
        val createCoupon = couponFactory.createCouponCode(metaInfo = metaInfo.toEntity())
        val foundCoupon = couponRepository.findByCode(code = createCoupon.code)

        return if(foundCoupon == null) createCoupon
        else createCoupon(metaInfo = metaInfo)
    }
}