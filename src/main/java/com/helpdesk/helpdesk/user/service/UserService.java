package com.helpdesk.helpdesk.user.service;

import com.helpdesk.helpdesk.user.dto.UserRequestDTO;
import com.helpdesk.helpdesk.user.dto.UserResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO createUsers(@Valid UserRequestDTO userRequestDTO);

    UserResponseDTO findUserById(Long id);

    UserResponseDTO updateUsers(Long Id, UserRequestDTO requestDTO);

    UserResponseDTO deletedUser(Long id);

    UserResponseDTO softDelete(Long id);
}
