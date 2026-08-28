package com.example.firstapplication.services;

import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.entities.User;
import com.example.firstapplication.mappers.UserMapper;
import com.example.firstapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getUser(String userId){
        UUID uuid = UUID.fromString(userId);
     Optional<User> user = userRepository.findById(uuid);
     return user.map(userMapper::toDTO).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();
    }

    public UserDTO updateUser(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findByFirstName(userDTO.firstName()).stream().findFirst();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userMapper.updateEntity(userDTO, user);
            User savedUser = userRepository.save(user);
            return userMapper.toDTO(savedUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    public List<UserDTO> createUsers(List<UserDTO> userDTOs) {
        List<User> users = userDTOs.stream().map(userMapper::toEntity).toList();
        List<User> savedUsers = userRepository.saveAll(users);
        return savedUsers.stream().map(userMapper::toDTO).toList();
    }

    public void deleteUser(String userId) {
        UUID uuid = UUID.fromString(userId);
        userRepository.deleteById(uuid);
    }
}
