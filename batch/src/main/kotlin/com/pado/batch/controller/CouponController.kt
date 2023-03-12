package com.pado.batch.controller

import org.bson.types.ObjectId
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.JobRegistry
import org.springframework.batch.core.explore.JobExplorer
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

// https://velog.io/@backtony/Spring-Batch-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%8F-%EC%9A%B4%EC%98%81

@RestController
@Configuration
class CouponController(
    private val jobLauncher: JobLauncher,
    private val jobRegistry: JobRegistry,
    private val jobExplorer: JobExplorer,
) {

    @PostMapping("/batch")
    fun runJob(@RequestBody request: CouponCreateRequest): ExitStatus? {

        // todo: Coupon Request를 Job parameter 변환으로 바꿔주기.

        // 잡 이름의 빈 검색
        val job: Job = jobRegistry.getJob(COUPON_CREATE_BATCH_JOB)

        // job 파라미터 추출
        // builder의 인자 -> (현재 만드는 잡 파라미터에 추가하고 싶은 잡파라미터, jobExplorer)
        // jobExplorer가 필요한 이유는 다음 파라미터를 위해 기존 run.id를 가져오기 위해서 필요함
        val jobParameters = JobParametersBuilder(request.jobParameters, jobExplorer)
            .getNextJobParameters(job)
            .toJobParameters()

        // 잡 실행하고 ExitStatus 반환
        return jobLauncher.run(job, jobParameters).exitStatus
    }
}

data class CouponCreateRequest(
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredDate: String, // todo: Instant로 바꾸기
)

class JobLaunchRequest() {
    val jobParameters: JobParameters
        get() = JobParametersBuilder(jobParameters).toJobParameters()
}

const val COUPON_CREATE_BATCH_JOB = "coupon-create-batch-job"