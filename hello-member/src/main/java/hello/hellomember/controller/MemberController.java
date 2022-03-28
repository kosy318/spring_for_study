package hello.hellomember.controller;

import hello.hellomember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 스프링이 처음에 뜰 때 스프링 컨테이너라는 스프링 통이 생기는데 거기에 Controller라는 annotation이 있으면 MemberController 객체를 생성해서 스프링에 넣어두고 스프링이 관리를 함
// 스프링 컨테이너에서 스프링 빈이 관리된다고 표현
@Controller
public class MemberController {

    // 스프링에서 받아 쓰는걸로 바꿔야함
    // 하나만 생성해서 같이 공유해서 쓰면 됨
    // private final MemberService memberService = new MemberService();

    // 스프링 컨테이너에 등록해서 쓰면됨
    // 생성자: alt+insert
    private final MemberService memberService;

    // 스프링 컨테이너가 뜰 때 생성자를 호출해서 생성
    // autowired라고 돼있으면 컨테이너에 있는 memberservice를 가져다가 연결을 시켜줌
    // MemberService class를 spring이 알 방법이 없어서 오류가 뜨므로 MemberService에가서 @Service를 적어주고 Repository에 @Repository를 넣어주자
    // MemberController가 생성될 때 스프링 빈에 등록되어있는 MemberService 객체를 가져다가 넣어줌 : dependency injection
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
