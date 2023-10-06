package hello.firstspring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "jhun");

        return "hello";
    }

    @GetMapping("/hello-mvc")
    @ResponseBody
    public String helloMvc(String name, Model model) {
        model.addAttribute("name", name);


        //
        return "hello-template";
    }
    
    @GetMapping("/json")
    @ResponseBody
    public Map<String, String> jsonReturnSample(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "111");
        map.put("age", "2222");
        return map;
    }
}
