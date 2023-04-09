package com.pado.batch.application

import com.pado.domain.factory.CouponFactory
import com.pado.domain.repository.mongo.MongoCouponRepository
import org.springframework.stereotype.Service

@Service
@Deprecated("Batch에서 create하지 않음")
class CouponCreateService(
//    private val mongoCouponRepository: MongoCouponRepository<Any?, Any?>,
    private val couponFactory: CouponFactory,
) {
//    fun create(title: String, reward: String){
//
//        mongoCouponRepository.save(createCoupon(title = title, reward = reward))
//
//    }
//
//    private fun createCoupon(title: String, reward: String): MongoCoupon {
//        val createCoupon = couponFactory.createCouponCode(metaInfo = null)
//        val foundCoupon = mongoCouponRepository.findByCode(code = createCoupon.code)
//
//        return if(foundCoupon == null) createCoupon
//        else createCoupon(title, reward)
//    }
}