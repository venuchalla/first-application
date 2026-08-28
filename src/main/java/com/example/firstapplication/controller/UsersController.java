package com.example.firstapplication.controller;

import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@RequestParam(name = "userId") String userId) {
        log.info("Fetching user with ID: {}", userId);

        UserDTO userDTO = userService.getUser(userId);
       return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        log.info("Creating user with ID: {}", userDTO.firstName());
        UserDTO createdUserDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        log.info("Updating user with ID: {}", userDTO.firstName());
        UserDTO updatedUserDTO = userService.updateUser(userDTO);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createUsers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> userDTOs) {
        log.info("Creating multiple users");
        List<UserDTO> createdUserDTOs = userService.createUsers(userDTOs);
        return new ResponseEntity<>(createdUserDTOs, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@RequestParam(name = "userId") String userId) {
        log.info("Deleting user with ID: {}", userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> patchUser(@RequestBody UserDTO userDTO) {
        log.info("Patching user with ID: {}", userDTO.firstName());
        UserDTO updatedUserDTO = userService.updateUser(userDTO);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }
    }