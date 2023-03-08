package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/user/paging")
    public @ResponseBody List<User> getPagingUser(
            @RequestParam(value = "page", defaultValue = "0") Integer page
            , @RequestParam(value = "size", defaultValue = "0") Integer size
    , @RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy));
        return userRepository.findAll(pageable).getContent();
    }

}
