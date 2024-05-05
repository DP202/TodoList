//package com.project.mini_project.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "fullname",length = 250)
//    private String fullName;
//    @Column(name = "email",unique = true)
//    private String email;
//    @Column(name = "password",nullable = false)
//    private String passWord;
//    @Column(name = "retype_password",nullable = false)
//    private String retypePassword;
//
//}
