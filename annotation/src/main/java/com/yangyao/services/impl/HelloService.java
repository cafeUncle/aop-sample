package com.yangyao.services.impl;

import org.springframework.stereotype.Service;
import com.yangyao.services.IHelloService;

@Service
public class HelloService implements IHelloService {
    @Override
    public String sayHello() {
        return "hello every one";
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public String sayHello(String name, String age) {
        return "Hello," + name + ", you're " + age;
    }

    @Override
    public String sayBye() {
        return "bye every one";
    }

    @Override
    public String sayBye(String name) {
        return "bye, " + name;
    }

    @Override
    public String sayBye(String name, String age) {
        return "bye," + name + ", you're " + age;
    }
}
