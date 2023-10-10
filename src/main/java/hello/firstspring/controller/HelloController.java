package hello.firstspring.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("/hello")
  public String hello(Model model) {
        model.addAttribute("data", "jhun");

    return "hello";
  }

  @GetMapping("/hello-mvc")
  public String helloMvc(@RequestParam String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
  }

  @GetMapping("/json")
  @ResponseBody
  public Map<String, String> jsonReturnSample() {
    Map<String, String> map = new HashMap<>();
    map.put("name", "111");
    map.put("age", "2222");
    return map;
  }

  @GetMapping("/hello-string")
  @ResponseBody
  public String helloString(@RequestParam String name) {
    return "hello " + name; // "hello spring"
  }

  @GetMapping("/hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam String name,@RequestParam String sex, @RequestParam int age) {
    Hello hello = new Hello();
    hello.setName(name);
    hello.setAge(age);
    hello.setSex(sex);
    return hello; // {"name":"spring"}
  }

  @GetMapping("/hello-api2")
  @ResponseBody
  public Hello helloApi2(@ModelAttribute Hello hello) {
    return hello; 
  }


  static class Hello {

    private String name;
    private String sex;

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

    private int age;


    public int getAge() {
      return this.age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
