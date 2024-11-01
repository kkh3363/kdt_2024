package com.myspring.service;

import com.myspring.domain.Member;
import com.myspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }
    // 회원 중복 검사
    private void validateDuplicateMember( Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    // 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById( memberId);
    }
}
