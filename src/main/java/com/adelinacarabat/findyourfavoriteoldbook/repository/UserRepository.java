package com.adelinacarabat.findyourfavoriteoldbook.repository;

import com.adelinacarabat.findyourfavoriteoldbook.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    boolean existsByEmail(String email);
    boolean deleteUserByFullName(UserEntity userEntity);

    Optional<UserEntity> findByFullName(String fullName);

}
