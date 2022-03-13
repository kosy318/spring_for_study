package hello.hellomember.domain;

// 컨트롤러
// 웹 MVC의 컨트롤러 역할
// 서비스
// 핵심 비즈니스 로직 구현(회원은 중복가입이 안된다거나)
// 도메인
// 비즈니스 도메인 객체(회원, 주문, 쿠폰 등등 주로 데이터베시읏에 저장하고 관리됨
// 리포지토리
// 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리

// 아직 데이터 저장소가 정해지지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계

public class Member {

    private Long id; // 임의의 값
    private String name; //이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
