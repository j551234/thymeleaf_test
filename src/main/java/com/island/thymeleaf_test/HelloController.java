package com.island.thymeleaf_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/")
    String sayHi() {
        return "hihi";
    }
    // default hello use template
    @RequestMapping("/hello")
    String sayHello(Model model) {
        String hello_text = "Hello my friend";
        People peopleInfo = new People();
        peopleInfo.setAge(30);
        peopleInfo.setName("David");
        model.addAttribute("people", peopleInfo);


        return "hello";
    }



    //show form input
    @RequestMapping("/add")
    String addPesron(People person, Model model) {
        String hello_text = "Hello my friend";
        System.out.println("form name" + person.getName());
        System.out.println("form age" + person.getAge());

        model.addAttribute("people", person);
        return "hello";
    }

    // to the form
    @RequestMapping("/addForm")
    String addForm(Model model) {
        People person = new People();  // 前一個範例有新增Person.java 的class
        model.addAttribute("people", person);

        return "add";
    }

    // redirect will do the api route function again
    @RequestMapping("/renew")
    String redirect(Model model, RedirectAttributes attributes) {
        People peopleInfo = new People();
        peopleInfo.setAge(9527);
        peopleInfo.setName("thx");
        model.addAttribute("people", peopleInfo);
        String showMessage = "from redirect message";
        attributes.addFlashAttribute("message", showMessage);
        return "redirect:/hello";
    }

}
