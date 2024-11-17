package org.example.oauth2authorizationserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 3자 플랫폼 사용 신청자의 Form으로부터 데이터를 받을 DTO
 */
public class RegisterDTO {

    private String clientName;
    private String clientSecret;
    private String redirectUris;
    private String postLogoutRedirectUris;
    private String scopes;

}
