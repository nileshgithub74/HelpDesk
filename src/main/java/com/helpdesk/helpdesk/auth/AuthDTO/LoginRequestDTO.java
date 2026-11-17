package com.helpdesk.helpdesk.auth.AuthDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Enter the valid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


}
