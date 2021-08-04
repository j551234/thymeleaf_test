package com.island.thymeleaf_test;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    int version = 100;

    public String sayHello() {
        return "hello";
    }

    public String sayGoodBye() {
        return "Bye";
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
