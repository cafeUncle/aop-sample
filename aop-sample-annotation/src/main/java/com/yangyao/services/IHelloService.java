package com.yangyao.services;

public interface IHelloService {

    public String sayHello();

    public String sayHello(String name);

    public String sayHello(String name, String age);

    public String sayBye();

    public String sayBye(String name);

    public String sayBye(String name, String age);
}
