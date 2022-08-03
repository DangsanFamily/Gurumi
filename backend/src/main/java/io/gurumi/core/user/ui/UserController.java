package io.gurumi.core.user.ui;


import io.gurumi.core.user.domain.User;
import io.gurumi.core.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/user")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }
    @PostMapping(path="/sign-up")
    public User insertUser(@RequestBody User requestUser){
         User responseUser;
         responseUser = userService.insertUser(requestUser);
        System.out.println(requestUser);
         return responseUser;
    }
    @GetMapping(path="/query")
    public String queryParamTest(@RequestParam(name="name") String name1, @RequestParam Integer age){
        System.out.println(name1 + age.toString());
        return name1;
    }

    @GetMapping(path="/path/{name1}/{age}")
    public String pathVariable(@PathVariable(name="name1") String name,@PathVariable Integer age){

        return name+age.toString();
    }

}
