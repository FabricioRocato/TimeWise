package com.example.timewise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "time_sheet")
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm", locale = "pt-BR", timezone = "America/Sao_Paulo")
    @Column(name = "hours_worked")
    private Date hoursWorked;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TimeSheet() {
        this.status = Status.PENDING;
    }
}