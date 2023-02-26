package com.kidsworld.batch.test

import com.pado.domain.entity.Coupon
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter

class CouponItemWriter : ItemWriter<Coupon> {
  override fun write(chunk: Chunk<out Coupon>) {

  }
}
