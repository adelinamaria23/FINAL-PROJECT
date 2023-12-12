package com.adelinacarabat.findyourfavoriteoldbook.controller;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.CustomResponseDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book.BookDTO;
import com.adelinacarabat.findyourfavoriteoldbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/books")
public class BookController implements BookApi{

    private final BookService bookService;

    public ResponseEntity<CustomResponseDTO> addBook(BookDTO bookDTO) {
        BookDTO responseBookDTO = bookService.addBook(bookDTO);

        return new ResponseEntity<>(
                CustomResponseDTO.builder()
                        .responseObject(responseBookDTO)
                        .responseMessage("User created successfully!").build(),
                HttpStatus.CREATED);
    }

    /*public ResponseEntity<CustomResponseDTO> getBookById(Long id) {
        UserDTO userDTO = bookService.findById(id);

        return new ResponseEntity<>(
                CustomResponseDTO.builder()
                        .responseObject(userDTO)
                        .responseMessage("User found with id " + id).build(),
                HttpStatus.OK);

    }

    public ResponseEntity<List<UserDTO>> getAllBooks(){

        return new ResponseEntity<>(bookService.findAllUsers(), HttpStatus.OK);
    }*/
}
