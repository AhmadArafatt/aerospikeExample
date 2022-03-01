package com.example.aerospikeexample.service;

import com.example.aerospikeexample.model.User;
import com.example.aerospikeexample.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

        private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
            return (List<User>) userRepository.findAll();
        }


    public void create(User user) {

    }

    public void removeUserById(long id) {
            userRepository.deleteById((int) id);
    }

    public String create(long id, String name, long salary) {
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setSalary(salary);

        userRepository.save(user);
        return "User has been Added";
    }

    public void create22(User user) {
    userRepository.save(user);
    }
}


