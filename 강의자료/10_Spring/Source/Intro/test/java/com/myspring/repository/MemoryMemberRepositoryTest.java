package com.myspring.repository;

import com.myspring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    @Test
    void 저장하기() {
        // given
        Member member =new Member();
        member.setName("kim");

        // when
        repo.save(member);
        // then
        Member result = repo.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }
}