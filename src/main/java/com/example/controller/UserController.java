package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value = "id") Long id) {
        User byId = userRepository.findById(id).get();
        return byId;
    }

}
