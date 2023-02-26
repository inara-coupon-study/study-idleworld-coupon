package com.kidsworld.batch.test

import com.pado.domain.annotation.EnableDomain
import com.pado.domain.entity.Coupon
import com.pado.domain.repository.CouponRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate


@EnableDomain
@Configuration
class TestBatch @Autowired constructor(
  private val jobBuilderFactory: JobBuilderFactory,
  private val stepBuilderFactory: StepBuilderFactory,
  private val couponRepository: CouponRepository,
  private val mongoTemplate: MongoTemplate,

  @Value("\${spring.batch.chunkSize:300}")
  var chunkSize: Int = 300,
) {

  // private val logger = KotlinLogging.logger {}

  @Bean
  fun batchTestJob(): Job {
    // logger.info(">> job test is starting!!")
    return jobBuilderFactory[BATCH_TEST_JOB_NAME]
      .start(testBatchStep())
      .build()
  }

  @Bean
  @JobScope
  fun testBatchStep(): Step {
    // logger.info(">> test batch Step is starting!!")
    return stepBuilderFactory[BATCH_TEST_JOB_NAME]
      .chunk<Coupon, Coupon>(chunkSize)
      .reader(batchTestReader())
      .processor(processor())
      .writer(writer())
      .build()

  }

  @Bean
  @StepScope
  fun batchTestReader(
  ): ItemReader<Coupon> = CouponItemReader(chunkSize = chunkSize).getCouponRepositoryItemReader(mongoTemplate)



  companion object {
    const val BATCH_TEST_JOB_NAME = "batch-test"
    private const val CHUNK_SLEEP_MILLIS: Long = 500
  }

}

@Bean
@StepScope
fun processor(): CouponItemProcessor {
  return CouponItemProcessor()
}

@Bean
@StepScope
fun writer(): CouponItemWriter {
  return CouponItemWriter()
}
