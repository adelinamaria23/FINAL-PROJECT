package com.adelinacarabat.findyourfavoriteoldbook.repository;

import com.adelinacarabat.findyourfavoriteoldbook.model.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

    List<PurchaseEntity> findAll();
    Optional<PurchaseEntity> findById(Long id);

}