package com.example.timewise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int userId;
    @Column(name="user_name")
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 10, message = "Username should be min 2 characters and max 10 characters")
    private String username;
    @NotNull
    @NotEmpty
    @Column(length = 100)
//    @Size(min = 2, max = 10, message = "Password should be min 2 characters and max 10 characters")
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

}