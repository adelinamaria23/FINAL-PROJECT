package com.adelinacarabat.findyourfavoriteoldbook.controller;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.CustomResponseDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {
    @CrossOrigin
    @Operation(
            summary = "Create a new user",
            description="Creates a new user with the properties passed in the request body",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User created successfully"
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Email already in use"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Wrong request body format"
                    )
            }
    )
    @RequestMapping(value = "/createUser",
    produces = {"application/json"},
    consumes = {"application/json"},
    method = RequestMethod.POST)
    ResponseEntity<CustomResponseDTO> createUser(@RequestBody UserDTO userDTO);

    @Operation(
            summary = "Returns user by user ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User retrieved successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    @GetMapping("/{id}")
    ResponseEntity<CustomResponseDTO> getUserById(@PathVariable @Valid Long id);


    @Operation(
            summary = "Returns a list with all users",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User retrieved successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found"
                    )
            }
    )
    @GetMapping("/allUsers")
    ResponseEntity<List<UserDTO>> getAllUsers();

    @GetMapping("/specificUsers/{fullName}/{address}/{age}")
    public ResponseEntity<List<UserDTO>> getUsers
            (@PathVariable String fullName, @PathVariable String address, @PathVariable int age);



}
