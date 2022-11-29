package com.knoldus.springbootswaggerexample.controller;

import com.knoldus.springbootswaggerexample.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();


    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
      return users.get(id);
    }

    @GetMapping("/getAll")
     public List<User>getAllUser()   {
       return new ArrayList<User>(users.values());

        }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
         users.put(user.getId(),user);
         return user;
    }

}

