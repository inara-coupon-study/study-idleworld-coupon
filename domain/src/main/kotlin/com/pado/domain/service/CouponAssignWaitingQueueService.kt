package com.pado.domain.service

import com.pado.domain.repository.RedisRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CouponAssignWaitingQueueService(
    private val redisRepository: RedisRepository,
) {

    fun registerQueue(key: String, value: Any): Boolean? {
        return redisRepository.zAddIfAbsent(key, value, score = System.currentTimeMillis().toDouble())
    }

    fun <T : Any> getQueue(key: String, startRank: Long = 0, endRank: Long, type: Class<T>): Queue<T> {
        return LinkedList(redisRepository.zRange(key, startRank, endRank, type) ?: emptySet())
    }

    fun <T : Any> popQueue(key: String, count: Long, type: Class<T>): Queue<T> {
        return LinkedList(redisRepository.zPopMin(key, count, type) ?: emptySet())
    }

    fun getWaitingOrder(key: String, value: Any): Long? {
        return redisRepository.zRank(key, value)
    }
}