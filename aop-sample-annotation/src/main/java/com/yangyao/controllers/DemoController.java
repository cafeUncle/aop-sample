package com.yangyao.controllers;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.yangyao.services.IHelloService;

import java.util.Random;

@RestController
public class DemoController {

    @Autowired
    IHelloService helloService;

    @GetMapping("hello")
    public String hello() {
        return "helloWorld!";
    }

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.sayHello(name);
    }

    @GetMapping("hello/{name}/{age}")
    public String hello(@PathVariable String name, @PathVariable String age) {
        return helloService.sayHello(name, age);
    }

    @GetMapping("bye")
    public String bye() {
        return helloService.sayBye();
    }

    @GetMapping("bye/{name}")
    public String bye(@PathVariable String name) {
        return helloService.sayBye(name);
    }

    @GetMapping("bye/{name}/{age}")
    public String bye(@PathVariable String name, @PathVariable String age) {
        return helloService.sayBye(name, age);
    }

    @GetMapping("bye/{name}/{age}/{sth}")
    public String bye(@PathVariable String name, @PathVariable String age, @PathVariable String sth) {
        if (new Random().nextInt(10) < 5) {
            throw new RuntimeException("some errors");
        }
        return helloService.sayBye(name, age);
    }
}
