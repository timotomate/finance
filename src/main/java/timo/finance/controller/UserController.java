package timo.finance.controller;

import org.springframework.web.bind.annotation.*;
import timo.finance.domain.User;
import timo.finance.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestParam String name,
                           @RequestParam String email) {
        return userService.save(name, email);
    }
}