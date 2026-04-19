package udtrucks.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import udtrucks.springaop.aspects.MyAspect;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var aspect = ctx.getBean(MyAspect.class);
        aspect.before();
        var userService = ctx.getBean(UserService.class);
        var user = new User("A415582", "Mike", "Dev");
        userService.printUser(user);
    }

}
