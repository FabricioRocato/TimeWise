package com.example.timewise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
@Getter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "active")
    private Boolean active;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role roles ;

    public Employee(){
        this.roles = Role.ROLE_USER;
        this.active = Boolean.TRUE;
    }
}