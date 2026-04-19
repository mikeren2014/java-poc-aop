package org.example.intercept;

import org.example.invoke.Invocation;

public interface Interceptor {
    public void before();

    public void after();

    public Object around(Invocation invocation) throws Throwable;

    public void afterReturning();

    public void afterThrowing();

    public default boolean userAround(){
        return false;
    }
}
