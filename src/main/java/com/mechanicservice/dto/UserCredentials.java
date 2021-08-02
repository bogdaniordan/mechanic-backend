package com.mechanicservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {
    private String firstName;
    private String secondName;
    private String username;
    private String password;
}
