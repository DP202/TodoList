//package com.project.mini_project.controllers;
//
//import com.project.mini_project.dtos.UserDTO;
//import com.project.mini_project.entities.User;
//import com.project.mini_project.services.IUserService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/users")
//public class UserController {
//
//    private  final IUserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
//       try{
//           User user = userService.createUser(userDTO);
//           return  ResponseEntity.ok(user);
//       }catch (Exception e){
//           return ResponseEntity.badRequest().body(e.getMessage());
//       }
//    }
//}
