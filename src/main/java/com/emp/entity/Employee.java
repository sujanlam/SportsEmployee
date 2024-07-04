package com.emp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private Integer age;
    private String club;
    private Integer goals_scored;
    private String nationality;

}
