package com.kidsworld.batch.test
import com.pado.domain.entity.Coupon
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.mongodb.core.MongoTemplate

class CouponItemReader(
  private val chunkSize: Int,
) {

  // private val logger = KotlinLogging.logger {}

  @Bean
  fun getCouponRepositoryItemReader(
    mongoTemplate: MongoTemplate,
  ): ItemReader<Coupon> {

    // logger.info(">> Test ItemReader starting!!")
    val sort: Map<String, Sort.Direction> = mapOf("code" to ASC)

    return  MongoItemReaderBuilder<Coupon>()
      .collection("coupon")
      .targetType(Coupon::class.java)
      .template(mongoTemplate)
      .parameterValues("stockCount")
      .jsonQuery("{stockCount:?0}")
      .sorts(sort)
      .saveState(false)
      .build()
  }
  companion object {
    private const val COUPON_REPOSITORY = "couponRepository"
    private const val COUPON_REPOSITORY_FIND_ALL_METHOD = "findAll"
  }
}
