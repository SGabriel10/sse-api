package com.api.controllers;

import com.api.dtos.user.UserDTO;
import com.api.dtos.user.UserResult;
import com.api.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private IUserService iUserService;

    @GetMapping( produces = { "application/json" })
    public UserResult getAll() {
        return iUserService.getAll(PageRequest.of(0, 5));
    }

    @PostMapping(produces = { "application/json" })
    public UserDTO save(@Valid @RequestBody UserDTO user) {
        return iUserService.save(user);
    }

}
