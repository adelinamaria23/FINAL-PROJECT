package com.adelinacarabat.findyourfavoriteoldbook.controller;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.CustomResponseDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface BookApi {

    @CrossOrigin
    @Operation(
            summary = "Add a new book",
            description="Adds a new book with the properties passed in the request body",
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
    @RequestMapping(value = "/createBook",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CustomResponseDTO> addBook(@RequestBody BookDTO bookDTO);

    /*@Operation(
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
    ResponseEntity<CustomResponseDTO> getBookById(@PathVariable @Valid Long id);


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
    ResponseEntity<List<UserDTO>> getAllBooks();*/
}
