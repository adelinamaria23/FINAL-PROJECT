package com.adelinacarabat.findyourfavoriteoldbook.repository;

import com.adelinacarabat.findyourfavoriteoldbook.model.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAll();
    Optional<BookEntity> findById(Long id);
}
