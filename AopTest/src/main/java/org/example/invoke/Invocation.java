package org.example.invoke;

import org.example.intercept.Interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;
    private Interceptor interceptor;

    public Invocation(Object target, Method method, Object[] params,
                      Interceptor interceptor){
        this.params = params;
        this.method = method;
        this.target = target;
        this.interceptor = interceptor;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException{
        Object retObj = null;
        boolean exceptionFlag = false;
        this.interceptor.before();

        try {
            retObj = method.invoke(target, params);
        } catch (Exception ex){
            exceptionFlag = true;
        }
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
        }
        this.interceptor.after();
        return retObj;
    }
}
