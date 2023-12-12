package com.adelinacarabat.findyourfavoriteoldbook.service;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book.BookDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.entities.BookEntity;
import com.adelinacarabat.findyourfavoriteoldbook.repository.BookRepository;
import com.adelinacarabat.findyourfavoriteoldbook.service.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    
    public BookDTO addBook(BookDTO bookDTO) {
        //validations to be done...

        BookEntity bookEntity = bookMapper.mapRequestToEntity(bookDTO);
        BookEntity bookToBeSavedInDB = bookRepository.save(bookEntity);

        return bookMapper.mapBookEntityToDTO(bookToBeSavedInDB);
    }

}
