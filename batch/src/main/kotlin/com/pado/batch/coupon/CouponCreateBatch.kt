package com.pado.batch.coupon

import com.pado.batch.application.CouponCreateService
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.support.AbstractPlatformTransactionManager

/*
* 배치는 tasklet or chunk(reader / writer) 방식이 있음.
* */


@Configuration
class CouponCreateBatch @Autowired constructor(
  private val couponCreateService: CouponCreateService,
  private val jobRepository: JobRepository,
  private val platformTransactionManager: AbstractPlatformTransactionManager,
) {

  @Bean
  fun couponCreateBatchJob(): Job {
    return JobBuilder("job Builder", jobRepository)
      .start(couponCreateBatchStep(count = 0, title = "", reward = ""))
      .build()
  }

  @Bean
  @JobScope
  fun couponCreateBatchStep(
    @Value("#{jobParameters[couponCount]}") count: Int,
    @Value("#{jobParameters[title]}") title: String,
    @Value("#{jobParameters[reward]}") reward: String,
  ): Step {

    println("test excute")
    return StepBuilder("set builder", jobRepository)
      .tasklet(CouponTasklet(
        couponCreateService = couponCreateService,
        count = count,
        reward = reward,
        title = title,
      ), platformTransactionManager)
      .build()

  }




  companion object {
    const val BATCH_TEST_JOB_NAME = "coupon-create-batch"
  }

}

