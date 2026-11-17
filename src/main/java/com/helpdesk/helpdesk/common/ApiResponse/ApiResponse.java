package com.helpdesk.helpdesk.common.ApiResponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {


    private boolean success;
    private T data;
    private String message;
    private LocalDateTime timestamp;

}
