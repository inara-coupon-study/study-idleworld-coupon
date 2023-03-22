package com.pado.domain.repository

import com.pado.domain.entity.RedisCoupon
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

// 참고 ) https://www.hides.kr/1109

// 레디스 전략
// 참고 ) https://velog.io/@korea3611/Spring-boot-%EC%A2%8B%EC%95%84%EC%9A%94%EC%88%98-%EC%A6%9D%EA%B0%80-%EB%B6%84%EC%82%B0%EB%9D%BD%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-%EB%8F%99%EC%8B%9C%EC%84%B1-%EC%A0%9C%EC%96%B4%ED%95%98%EA%B8%B0-redis%ED%99%9C%EC%9A%A9%ED%95%98%EA%B8%B0
// 1) write through
// 2) lazy

// redis config
// 참고) https://blog.naver.com/semtul79/222235108317

// redis repository
// 참고) https://sabarada.tistory.com/106?category=856943
interface RedisTestRepository : CouponRepository<RedisCoupon, String>