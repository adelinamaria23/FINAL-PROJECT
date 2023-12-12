package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookDTO {

    private String name;
    private Set<AuthorDTO> authorsDTO;
    private LocalDate publishDate;
    private String publishingHouse;
    private boolean hasVolumes;
    private int volumes;

}
