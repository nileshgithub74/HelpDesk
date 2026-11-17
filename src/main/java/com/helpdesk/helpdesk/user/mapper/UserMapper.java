package com.helpdesk.helpdesk.user.mapper;

import com.helpdesk.helpdesk.user.dto.UserRequestDTO;
import com.helpdesk.helpdesk.user.dto.UserResponseDTO;
import com.helpdesk.helpdesk.user.entity.User;

public class UserMapper {

    public static UserResponseDTO EntitytoResponse(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setFirstname(user.getFirstname());
        userResponseDTO.setLastname(user.getLastname());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setStatus(user.getStatus());
        userResponseDTO.setUpdatedAt(user.getUpdatedAt());
        userResponseDTO.setCreatedAt(user.getCreatedAt());

        return userResponseDTO;
    }

    public static User RequestToEntity(UserRequestDTO request) {
        User user = new User();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public static User UpdateMapper(UserRequestDTO request, User user) {
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;

    }
}
