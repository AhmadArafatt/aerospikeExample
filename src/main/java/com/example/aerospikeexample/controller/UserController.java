package com.example.aerospikeexample.controller;
import com.example.aerospikeexample.exception.ApiRequestException;
import com.example.aerospikeexample.model.User;
import com.example.aerospikeexample.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{keyy}")
    public Map<String, Object> getUser(@PathVariable String keyy) {
        try {
            return userService.findAUser(keyy);
        }
        catch (Exception exc) {
            throw new ApiRequestException("User doesnt found");
        }
    }

    @GetMapping("/getAllUsers")
    public List<Map<String, Object>> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/addUser/{keyy}")
    public String create(@RequestBody User user, @PathVariable String keyy) {
        return userService.create( user,keyy);
    }
    @DeleteMapping("/delete/{key}")
    public String delete(@PathVariable String key) {
        return userService.delete(key);
    }

    @PutMapping("/udateSalary/{key}")
    public String update(@PathVariable String key,@RequestBody Map<String,Object> body) {
        return userService.update(key,body.get("Salary").toString());
    }
}
