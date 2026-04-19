package udtrucks.springaop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    public MyAspect() {
        System.out.println("MyAspect created");
    }
    private static final String aopExp = "execution(* " +
            "udtrucks.springaop.UserServiceImpl.printUser(..))";

    @Pointcut(aopExp)
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before....");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning....");

    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing....");

    }

}