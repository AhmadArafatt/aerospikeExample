package com.example.aerospikeexample.controller;


import com.example.aerospikeexample.model.User;
import com.example.aerospikeexample.repository.UserRepository;
import com.example.aerospikeexample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }


    @GetMapping("/addUser/{id}/{name}/{salar}")
    public String create(@PathVariable long id,@PathVariable String name,@PathVariable long salar){

        return userService.create(id,name,salar);
    }
    @PostMapping("/add")
    public List<User> create2(@RequestBody final User user){

         userService.create22(user);
         return getAllUsers();

    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.removeUserById(id);
    }

}
