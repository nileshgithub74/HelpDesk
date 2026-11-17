package com.helpdesk.helpdesk.auth.AuthDTO;

import com.helpdesk.helpdesk.user.dto.UserResponseDTO;
import lombok.*;


@Getter
@Setter
public class LoginResponseDTO {
    private String accessToken;
    private String tokenType;
    private long expireIn;
    private UserResponseDTO user;
}
