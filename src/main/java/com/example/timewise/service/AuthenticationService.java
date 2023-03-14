package com.example.timewise.service;

import com.example.timewise.dto.CredentialsDto;
import com.example.timewise.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap("the-password"));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), encodedMasterPassword)) {
            return new UserDto(1L, "Sergio", "Lema", "login", "token");
        }
        throw new RuntimeException("Invalid password");
    }

    public UserDto findByLogin(String login) {
        if ("login".equals(login)) {
            return UserDto().getLogin();
        }
        throw new RuntimeException("Invalid login");
    }
}
