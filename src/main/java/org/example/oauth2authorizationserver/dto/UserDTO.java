package org.example.oauth2authorizationserver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private String nickname;
    private String phone;
}
