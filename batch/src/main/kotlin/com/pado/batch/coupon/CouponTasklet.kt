package com.pado.batch.coupon

import com.pado.batch.application.CouponCreateService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus

class CouponTasklet(
    private val couponCreateService: CouponCreateService,
    private val title: String,
    private val reward: String,
    private val count: Int,
) : Tasklet{
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {

        println("test excute")
        for(i in 1..count) couponCreateService.create(title = title, reward = reward)

        return RepeatStatus.FINISHED
    }
}