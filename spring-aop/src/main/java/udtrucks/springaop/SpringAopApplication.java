package udtrucks.springaop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //var ctx = SpringApplication.run(SpringAopApplication.class, args);
        var userService = ctx.getBean(UserService.class);
        System.out.println("UserService class: " + userService.getClass());
        var user = new User("A415582", "Mike", "Dev");
        userService.printUser(user);
    }

}
