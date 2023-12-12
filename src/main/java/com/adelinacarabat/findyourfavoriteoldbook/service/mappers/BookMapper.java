package com.adelinacarabat.findyourfavoriteoldbook.service.mappers;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book.AuthorDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book.BookDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.entities.AuthorEntity;
import com.adelinacarabat.findyourfavoriteoldbook.model.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookEntity mapRequestToEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(bookDTO.getName());
        bookEntity.setAuthors(mapRequestAuthorsToEntities(bookDTO.getAuthorsDTO()));
        bookEntity.setPublishDate(bookDTO.getPublishDate());
        bookEntity.setPublishingHouse(bookDTO.getPublishingHouse());
        bookEntity.setHasVolumes(bookDTO.isHasVolumes());
        bookEntity.setVolumes(bookDTO.getVolumes());

        return bookEntity;

    }

    public BookDTO mapBookEntityToDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setName(bookEntity.getTitle());
        bookDTO.setAuthorsDTO(mapAuthorEntityToDTO(bookEntity.getAuthors()));
        bookDTO.setPublishDate(bookEntity.getPublishDate());
        bookDTO.setPublishingHouse(bookEntity.getPublishingHouse());
        bookDTO.setHasVolumes(bookDTO.isHasVolumes());
        bookDTO.setVolumes(bookEntity.getVolumes());

        return bookDTO;

    }

    public Set<AuthorEntity> mapRequestAuthorsToEntities(Set<AuthorDTO> authors) {
        return authors.stream()
                .map(author ->
                    new AuthorEntity(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate(),
                            author.getNationality()))
                .collect(Collectors.toSet());
    }

    public Set<AuthorDTO> mapAuthorEntityToDTO (Set<AuthorEntity> authors) {
        return authors.stream()
                .map(author ->
                        new AuthorDTO(author.getFirstName(), author.getLastName(), author.getBirthDate(),
                                author.getNationality()))
                .collect(Collectors.toSet());
    }

}
