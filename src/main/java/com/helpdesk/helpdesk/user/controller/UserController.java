package com.helpdesk.helpdesk.user.controller;


import com.helpdesk.helpdesk.common.ApiResponse.ApiResponse;
import com.helpdesk.helpdesk.user.dto.UserRequestDTO;
import com.helpdesk.helpdesk.user.dto.UserResponseDTO;
import com.helpdesk.helpdesk.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get users;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {

        List<UserResponseDTO> allusers = userService.getAllUsers();

        ApiResponse<List<UserResponseDTO>> response = new ApiResponse<>(true,
                allusers,
                "users Fetched Successfully",
                LocalDateTime.now()

        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // create user

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        UserResponseDTO createdUser = userService.createUsers(userRequestDTO);
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(
                true,
                createdUser,
                "User Created Successfully!!",
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
    // get the user by id;


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable("id") Long id) {

        UserResponseDTO user = userService.findUserById(id);
        ApiResponse<UserResponseDTO> res = new ApiResponse<>(
                true,
                user,
                "User Fetch successully",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.FOUND).body(res);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUsers(@PathVariable("id") Long id, @RequestBody UserRequestDTO userRequestDTO) {

        UserResponseDTO updateUser = userService.updateUsers(id, userRequestDTO);
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(
                true,
                updateUser,
                "User updated succesFully",
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> deletedUser(@PathVariable("id") Long id) {
        UserResponseDTO deletedUser = userService.deletedUser(id);
        ApiResponse<UserResponseDTO> res = new ApiResponse<>(
                true,
                deletedUser,
                "User Deleted Successfully",
                LocalDateTime.now()


        );
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }


    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> softDelete(@PathVariable("id") Long id) {
        UserResponseDTO deletedUser = userService.deletedUser(id);
        ApiResponse<UserResponseDTO> res = new ApiResponse<>(
                true,
                deletedUser,
                "User Deleted Successfully",
                LocalDateTime.now()


        );
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }


}
