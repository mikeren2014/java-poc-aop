package udtrucks.springaop;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(User user) {
        if (user == null){
            throw new RuntimeException("User is null");
        }
        System.out.print(user);
    }
}
