package org.example.impl;

import org.example.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())){
            throw new RuntimeException("Parameter is null");
        }
        System.out.println("hello" + name);
    }
}
