package com.helpdesk.helpdesk.user.dto;


import com.helpdesk.helpdesk.user.enums.UserRole;
import com.helpdesk.helpdesk.user.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class UserResponseDTO {
    private Long Id;
    private String firstname;
    private String lastname;

    private UserRole role;
    private String email;

    private UserStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
