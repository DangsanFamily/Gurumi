package io.gurumi.core.user.service;

import io.gurumi.core.user.domain.User;
import io.gurumi.core.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    };

    public User insertUser(User requestUser){
        User responseUser;

        responseUser=userRepository.save(requestUser);

        return responseUser;

    }

}
