package hello.hellomember.service;

import hello.hellomember.domain.Member;
import hello.hellomember.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 회원 리포지토리와 도메인을 활용해서 실제 비즈니스 로직을 작성
// 서비스는 비즈니스에 의존적이게 설계
@Service // spring이 올라올 때 spring이 컨테이너에 MemberService를 등록해줌
public class MemberService {
    // create new test : ctrl+shift+t
    private final MemberRepository memberRepository; // = new MemoryMemberRepository();

    // Test에서 사용하는 MemoryMemberRepository와 MemberService에서 사용하는 MemoryMemberRepository()는 다른 repository라서 문제임
    // memberRepository를 직접 생성하는것이 아니라 외부에서 넣어주게끔 만듦
    @Autowired // 얘도 연결!! MemberService를 Spring이 생성을 할 때, 이 생성자를 호출, Autowired가 있으면, MemberRepository가 필요하는것을 알고 컨테이너에 있는 MemberRepository를 넣어줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    회원가입
    public Long join(Member member){
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member); // 저장
        return member.getId();
    }

    // refactoring => Extract method : ctrl+alt+m
    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원 x
        // 리턴값 받는 variable 생성: ctrl+alt+v
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // null이 아닌 값이 존재하면 이라는 의미, Optional이기 때문에 가능
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        // result.orElseGet(메서드); 값이 있으면 꺼내고 없으면 안의 메서드를 실행하라는 의미

        //위의 것을 줄여서 다음과같이 쓸 수있다. 어차피 findByName한 결과가 Optional<Member>이기 때문에
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
