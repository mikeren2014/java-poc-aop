package org.example;

import org.example.impl.HelloServiceImpl;
import org.example.intercept.MyInterceptor;
import org.example.invoke.Invocation;
import org.example.proxy.ProxyBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        var helloService = new HelloServiceImpl();

        var proxy = (HelloServiceImpl) ProxyBean.getProxy(helloService, new MyInterceptor());

        proxy.sayHello("Mike");
    }

    private static void Test1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        var helloService = new HelloServiceImpl();

        var interceptor = new MyInterceptor();

        var invocation = new Invocation(helloService,
                HelloServiceImpl.class.getMethod("sayHello", String.class),
                new Object[]{"Mike"}, interceptor);

        invocation.proceed();
    }
}