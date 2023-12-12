package com.adelinacarabat.findyourfavoriteoldbook.controller;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.CustomResponseDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController implements UserApi{

    private final UserService userService;

    public ResponseEntity<CustomResponseDTO> createUser(UserDTO userDTO) {
        UserDTO responseUserDTO = userService.createUser(userDTO);

        return new ResponseEntity<>(
                CustomResponseDTO.builder()
                        .responseObject(responseUserDTO)
                        .responseMessage("User created successfully!").build(),
                HttpStatus.CREATED);
    }

    public ResponseEntity<CustomResponseDTO> getUserById(Long id) {
        UserDTO userDTO = userService.findById(id);

        return new ResponseEntity<>(
                CustomResponseDTO.builder()
                        .responseObject(userDTO)
                        .responseMessage("User found with id " + id).build(),
                HttpStatus.OK);

    }

    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    public ResponseEntity<List<UserDTO>> getUsers
            (String fullName, String address, int age) {

        return new ResponseEntity<>(userService.getUsers(fullName, address, age), HttpStatus.OK);
    }
}
