package com.pado.api.controller

import com.pado.domain.entity.Member
import com.pado.domain.repository.MemberRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val memberRepository: MemberRepository,
) {

    @GetMapping("/test")
    @Transactional
    fun test(): MutableList<Member> {
        memberRepository.save(Member())
        return memberRepository.findAll()

    }
}