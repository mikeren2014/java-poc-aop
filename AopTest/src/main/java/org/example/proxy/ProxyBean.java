package org.example.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.example.intercept.Interceptor;
import org.example.invoke.Invocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyBean implements MethodInterceptor {

    private Interceptor interceptor = null;
    private  Object target = null;

    public static Object getProxy(Object target, Interceptor interceptor){
        var enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setInterfaces(target.getClass().getInterfaces());

        var proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        enhancer.setCallback(proxyBean);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        var invocation = new Invocation(target, method, args, interceptor);

        Object result = null;
        if (this.interceptor.userAround()){
            result = interceptor.around(invocation);
        } else {
            result = invocation.proceed();
        }
        return result;
    }
}
