package com.adelinacarabat.findyourfavoriteoldbook.controller;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.CustomResponseDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UpdateUserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    public ResponseEntity<CustomResponseDTO> updateUser(UpdateUserDTO updateUserDTO){
        UserDTO userDTO = userService.updateUserAddress(updateUserDTO);

        return new ResponseEntity<>(CustomResponseDTO.builder()
                .responseObject(userDTO)
                .responseMessage("User's address successfully updated.").build(), HttpStatus.OK);
    }

   /* public ResponseEntity<CustomResponseDTO> deleteUserRequest(@RequestBody UpdateUserDTO updateUserDTO){
        boolean deleted = userService.deleteUserByFullName(updateUserDTO);

        if(deleted){
            return new ResponseEntity<>(CustomResponseDTO.builder()
                    .responseMessage("User deleted successfully")
                    .build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(CustomResponseDTO.builder()
                    .responseMessage("User could not be deleted.")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/


}
