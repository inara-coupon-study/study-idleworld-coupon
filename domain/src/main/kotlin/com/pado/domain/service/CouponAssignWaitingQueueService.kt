package com.pado.domain.service

import com.pado.domain.repository.RedisTestRepository
import org.springframework.stereotype.Service

@Service
class CouponAssignWaitingQueueService(
    private val redisTestRepository: RedisTestRepository,
) {

//    fun registerQueue(key: String, value: Any): Boolean? {
//        return redisTestRepository.zAddIfAbsent(key, value, score = System.currentTimeMillis().toDouble())
//    }
//
//    fun <T : Any> getQueue(key: String, startRank: Long = 0, endRank: Long, type: Class<T>): Queue<T> {
//        return LinkedList(redisTestRepository.zRange(key, startRank, endRank, type) ?: emptySet())
//    }
//
//    fun <T : Any> popQueue(key: String, count: Long, type: Class<T>): Queue<T> {
//        return LinkedList(redisTestRepository.zPopMin(key, count, type) ?: emptySet())
//    }
//
//    fun getWaitingOrder(key: String, value: Any): Long? {
//        return redisTestRepository.zRank(key, value)
//    }
}