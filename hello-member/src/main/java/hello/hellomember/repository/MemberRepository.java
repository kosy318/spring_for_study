package hello.hellomember.repository;

import hello.hellomember.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장하면 저장된 회원이 반환됨

    // findById와 findByName으로 찾아올 수 있음
    Optional<Member> findById(Long id); // 가져온 값이 null이면 어떻게 반환할것인지 -> optional
    Optional<Member> findByName(String name);

    // 저장한 모든 회원 리스트를 반환
    List<Member> findAll();
}
