//package com.project.mini_project.services;
//
//import com.project.mini_project.dtos.UserDTO;
//import com.project.mini_project.entities.User;
//import com.project.mini_project.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements IUserService{
//
//    private final UserRepository userRepository;
//
//    @Override
//    public User createUser(UserDTO userDTO) {
//        String email = userDTO.getEmail();
//        if(userRepository.existsByEmail(email)){
//            throw new DataIntegrityViolationException("Email đã tồn tại !!!");
//        }
//        if(!userDTO.getPassword().equals(userDTO.getRetypePassword())){
//            throw new DataIntegrityViolationException("Password và RetypePassword không giống nhau !");
//        }
//        User newUSer = User
//                .builder()
//                .email(userDTO.getEmail())
//                .fullName(userDTO.getFullname())
//                .passWord(userDTO.getPassword())
//                .retypePassword(userDTO.getRetypePassword())
//                .build();
//        return userRepository.save(newUSer);
//    }
//
//    @Override
//    public String login(String email, String password) {
//        return "";
//    }
//}
