package com.example.timewise.service;

import com.example.timewise.dto.SignUpDto;
import com.example.timewise.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void addFriend(Long friendId) {
        return;
    }

    public UserDto signUp(SignUpDto user) {
        return new UserDto(1L, "Sergio", "Lema", "login", "token");
    }

    public void signOut(UserDto user) {
        // nothing to do at the moment
    }
}