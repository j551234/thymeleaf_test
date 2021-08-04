package com.island.thymeleaf_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallService {
    @Autowired
    HelloService helloService;

    public String callHello() {
        return helloService.sayHello();
    }

    public String callGoodBye() {
        return helloService.sayGoodBye();
    }
}
