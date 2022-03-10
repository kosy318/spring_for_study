// 웹 어플리케이션에서 첫번째 진입점 = controller

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @controller를 적어줘야한다.
@Controller
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 hello라고 들어오면 이 method를 호출한다.
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // data를 hello라고 넘길거임?
        return "hello";
    }
}
