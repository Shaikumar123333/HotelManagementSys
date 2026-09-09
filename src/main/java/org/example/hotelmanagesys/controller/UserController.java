package org.example.hotelmanagesys.controller;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.RegisterRequest;
import org.example.hotelmanagesys.Dto.UserDTO;
import org.example.hotelmanagesys.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor


public class UserController {

    private final UserService userservice;

    @PostMapping
    public UserDTO createUser(@RequestBody RegisterRequest req){
        return userservice.createUser(req);
    }

    @GetMapping
    public List<UserDTO> getAllBuses(){
        return userservice.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id){
        return userservice.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id){
        return userservice.deleteUser(id);
    }



}
