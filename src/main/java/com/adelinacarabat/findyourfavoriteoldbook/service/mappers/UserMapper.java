package com.adelinacarabat.findyourfavoriteoldbook.service.mappers;

import com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user.UserDTO;
import com.adelinacarabat.findyourfavoriteoldbook.model.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapRequestToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setFullName(userDTO.getFirstName() + " " + userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setBirthDate(userDTO.getBirthDate());
        userEntity.setAddress(userDTO.getAddress());
        return userEntity;
    }

    public UserDTO mapUserEntityToResponseUserDTO(UserEntity userEntity) {

        return UserDTO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .fullName(userEntity.getFullName())
                .birthDate(userEntity.getBirthDate())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .address(userEntity.getAddress()).build();
    }



}
