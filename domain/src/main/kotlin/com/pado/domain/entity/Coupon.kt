package com.pado.domain.entity

import com.pado.domain.type.CouponType
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


// https://fastcampus.co.kr/story_article_yhs
// https://devhaks.github.io/2019/11/30/mongodb-model-relationships/#Embedded
/**
 * reference: mongodb의 Join같은 lookup을 사용해야해서 read 속도가 많이 느림. 데이터 일관성을 보장해야하는 경우 transaction을 사용해야할 수 있음.
 * embedded: 지금 contents에 적용하고있는 방식. document 단위로 원자성이 잘 보장되지만, 데이터 중복이 발생하고 내장된 데이터 수정이 필요하다면 모든 내장 doc을 다 수정해야함
 *           추가로, embedded 방식은 document 크기가 과하게 커질 수 있음. 도큐먼트 최대 크기는 16MB
 * 즉, 내장시엔 수정할게 많고 참조시엔 lookup을 사용해야한다는 문제가 있다.
 * 결론은, 잘 변하지 않는 데이터만 내장시킨다.
 *
 * 카테고리 데이터의 경우 빈번하게 수정되지만, 그보다 더 빈번하게 조회된다. 컨텐츠 조회시마다 카테고리가 조회되는 구조이기 때문.
 * 음.. 그런데 category로 contents list를 조회하는게 더 빈번하지 않나.
 */

// mongo db 공식문서 flexible schema - modeling introduction
// https://www.mongodb.com/docs/manual/core/data-modeling-introduction/
/**
 * 같은 document (table)에 있어도 다른 필드와 데이터타입을 가질 수 있음.
 * mongodb는 document에 다른 doc을 embedded 또는 reference 가능.
 *
 * db operation이 embedded된 여러 document를 수정하더라도 원자성(atonomic)을 제공한다.(트랜잭션)
 * 단 update many를 진행할 땐 각 doc별 원자성은 제공되지만 전체 doc에 대한 원자성은 제공되지 않는다
 */

// 결론은, 컨텐츠에서 카테고리는 일관성이 보장되어야 하므로 reference로 가는건 어떨까? reference list..


// 쿠폰 document 하나가 쿠폰의 종류이다.
@Document(collation = "coupon")
class Coupon(
    val code: String,
    val title: String,
    val reward: String,
)