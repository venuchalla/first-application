package com.example.firstapplication.mappers;


import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.entities.Address;
import com.example.firstapplication.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {


    public UserDTO toDTO(User user);


   public User toEntity(UserDTO userDTO);
    @Mapping(source = "addressLineOne", target = "addressLine1")
    @Mapping(source = "addressLineTwo", target = "addressLine2")
    UserDTO.Address toDto(Address address);

    @Mapping(source = "addressLine1", target = "addressLineOne")
    @Mapping(source = "addressLine2", target = "addressLineTwo")
    Address toEntity(UserDTO.Address dto);

   public void updateEntity(UserDTO dto, @MappingTarget User user);
}