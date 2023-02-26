package com.kidsworld.batch.test

import com.pado.domain.entity.Coupon
import org.springframework.batch.item.ItemProcessor

class CouponItemProcessor : ItemProcessor<Coupon, Coupon> {
  // private val logger = KotlinLogging.logger {}
  override fun process(item: Coupon): Coupon? {
    // logger.info(">> item log: ${item.code}")
    return item
  }
}
