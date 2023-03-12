package com.pado.batch.application

import com.pado.domain.entity.Coupon
import com.pado.domain.factory.CouponFactory
import com.pado.domain.repository.CouponRepository
import org.springframework.stereotype.Service

@Service
class CouponCreateService(
    private val couponRepository: CouponRepository,
    private val couponFactory: CouponFactory,
) {
    fun create(title: String, reward: String){

        couponRepository.save(createCoupon(title = title, reward = reward))

    }

    private fun createCoupon(title: String, reward: String): Coupon {
        val createCoupon = couponFactory.createCouponCode(metaInfo = null)
        val foundCoupon = couponRepository.findByCode(code = createCoupon.code)

        return if(foundCoupon == null) createCoupon
        else createCoupon(title, reward)
    }
}