package org.example.intercept;

import org.example.invoke.Invocation;

import static java.lang.System.out;

public class MyInterceptor implements Interceptor{

    @Override
    public boolean userAround() {
        return true;
    }

    @Override
    public void before() {
        out.println("before....");
    }

    @Override
    public void after() {
        out.println("after....");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        out.println("around before....");
        invocation.proceed();
        out.println("around after....");
        return null;
    }

    @Override
    public void afterReturning() {
        out.println("afterReturning....");
    }

    @Override
    public void afterThrowing() {
        out.println("afterThrowing....");
    }
}
