package com.adelinacarabat.findyourfavoriteoldbook.service;

import com.adelinacarabat.findyourfavoriteoldbook.exception.DuplicateEmailException;
import com.adelinacarabat.findyourfavoriteoldbook.exception.UserCreationException;
import com.adelinacarabat.findyourfavoriteoldbook.exception.UserNotFoundException;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UpdateUserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.entities.UserEntity;
import com.adelinacarabat.findyourfavoriteoldbook.repository.UserRepository;
import com.adelinacarabat.findyourfavoriteoldbook.service.mappers.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public UserDTO createUser(UserDTO userDTO) {
        boolean userAlreadyExists = existsByEmail(userDTO.getEmail());
        if (userAlreadyExists) {
            throw new UserCreationException("Email already in use");
        }
        UserEntity userEntity = userMapper.mapRequestToEntity(userDTO);
        UserEntity createdUser = userRepository.save(userEntity);
        return userMapper.mapUserEntityToResponseUserDTO(createdUser);
    }

    public UserDTO findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));

        return userMapper.mapUserEntityToResponseUserDTO(userEntity);
    }

    public List<UserDTO> findAllUsers(){
        List<UserEntity> userEntities =  userRepository.findAll();
        List<UserDTO> users = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            users.add(userMapper.mapUserEntityToResponseUserDTO(userEntity));
        }
        return users;
    }
    public boolean existsByEmail(String email) {

        if (Objects.isNull(email) || email.isBlank()) {
            return false;
        }
        return userRepository.existsByEmail(email);

    }

    private boolean isDuplicateEmailViolation(DataIntegrityViolationException ex) {
        return ex.getMessage().contains("duplicate key value violates unique constraint");
    }

    private int calculateAge(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdate, currentDate);
        return period.getYears();
    }

    public List<UserDTO> getUsers(String fullName, String address, int age) {
        List<UserEntity> userEntities =  userRepository.findAll();
        List<UserDTO> users = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            int userAge = calculateAge(userEntity.getBirthDate());
            if(userEntity.getFullName().equalsIgnoreCase(fullName) && userEntity.getAddress().equalsIgnoreCase(address)
                    && userAge == age) {

                users.add(UserDTO.builder()
                        .firstName(userEntity.getFirstName())
                        .lastName(userEntity.getLastName())
                        .fullName(userEntity.getFullName())
                        .birthDate(userEntity.getBirthDate())
                        .email(userEntity.getEmail())
                        .phoneNumber(userEntity.getPhoneNumber())
                        .address(userEntity.getAddress()).build());
            }
        }
    return users;
    }

    @Transactional
    public UserDTO updateUserAddress(UpdateUserDTO updateUserDTO) {
        UserEntity userEntity = findUserEntity(updateUserDTO).get();
        userEntity.setAddress(updateUserDTO.getAddress());
        userRepository.save(userEntity);

        return userMapper.mapUserEntityToResponseUserDTO(userEntity);
    }

    @Transactional
    private Optional<UserEntity> findUserEntity(UpdateUserDTO updateUserDTO) {
        List<UserEntity> userEntity = userRepository.findAll();

        for(UserEntity user : userEntity) {
            if (user.getFirstName().equalsIgnoreCase(updateUserDTO.getFirstName())
            && user.getLastName().equalsIgnoreCase(updateUserDTO.getLastName())) {
                return Optional.of(user);
            }
        }
        return Optional.of(new UserEntity());
    }

    /*@Transactional
    public boolean deleteUserByFullName(UpdateUserDTO updateUserDTO) {
        UserEntity userEntity = findUserEntity(updateUserDTO).get();
        userRepository.deleteUserByFullName(userEntity);
        Optional<UserEntity> deletedEntity = findUserEntity(updateUserDTO);
        return deletedEntity.isPresent();
    }*/
}
