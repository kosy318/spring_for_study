// 웹 어플리케이션에서 첫번째 진입점 = controller

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// @controller를 적어줘야한다.
@Controller
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 hello라고 들어오면 이 method를 호출한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // data를 hello라고 넘길거임?
        return "hello";
    }


    // MVC 설명 중 작성
    // MVC 와 템플릿 엔진
    // 서버에서 html을 동적으로 변형을 해서 내려주는 방식
    // Model, View, Controller

    // 웹에서 parameter 받음
    // localhost:8080/hello-mvc?name=spring! 이런식으로 열어야함
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ){
        model.addAttribute("name", name);
        // hello-template.html에 넘김
        return "hello-template";
    }

    // API 설명 중 작성
    // API
    // json 포맷으로 client 에게 전달
    // 서버끼리 통신할 때
    @GetMapping("hello-string")
    @ResponseBody // 데이터를 그대로 내려줌, http body에 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // API 설명 중 작성2
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  // 객체이기 때문에 json 형식으로 리턴됨
    }

    static class Hello{
        private String name;

        // alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
