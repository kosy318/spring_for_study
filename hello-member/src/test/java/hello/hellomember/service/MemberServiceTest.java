package hello.hellomember.service;

import hello.hellomember.domain.Member;
import hello.hellomember.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;// = new MemberService();
    MemoryMemberRepository memberRepository;// = new MemoryMemberRepository();

    // 각 테스트를 실행하기전에 생성해줌
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    // test 방법: given when then
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when: 검증할 것
        Long saveId = memberService.join(member);

        // then: 검증
        Member findMember = memberService.findOne(saveId).get();
        // alt+enter
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 예외도 test 해야함
    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // then
        // 예외 잡는법 1
//        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // 예외 잡는법 2
        // memberService.join(member2)를 넣으면 IllegalStateException이 터져야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 메세지 검증
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}