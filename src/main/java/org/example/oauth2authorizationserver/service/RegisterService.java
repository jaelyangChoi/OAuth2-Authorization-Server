package org.example.oauth2authorizationserver.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2authorizationserver.dto.RegisterDTO;
import org.example.oauth2authorizationserver.entity.RegisterEntity;
import org.example.oauth2authorizationserver.repository.RegisterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterEntity register(RegisterDTO registerDTO){
        RegisterEntity entity = new RegisterEntity();

        entity.setId(UUID.randomUUID().toString());
        entity.setClientId(UUID.randomUUID().toString());
        entity.setClientIdIssuedAt(Instant.now());
        entity.setClientSecret(passwordEncoder.encode(UUID.randomUUID().toString()));
        entity.setClientAuthenticationMethods("client_secret_basic");
        entity.setAuthorizationGrantTypes("refresh_token, authorization_code");

        entity.setClientName(registerDTO.getClientName());
        entity.setRedirectUris(registerDTO.getRedirectUris());
        entity.setPostLogoutRedirectUris(registerDTO.getPostLogoutRedirectUris());
        entity.setScopes(registerDTO.getScopes());

        entity.setClientSettings("{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.client.require-proof-key\":false,\"settings.client.require-authorization-consent\":true}");
        entity.setTokenSettings("{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.token.reuse-refresh-tokens\":true,\"settings.token.x509-certificate-bound-access-tokens\":false,\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"],\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.access-token-format\":{\"@class\":\"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat\",\"value\":\"self-contained\"},\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000],\"settings.token.authorization-code-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.device-code-time-to-live\":[\"java.time.Duration\",300.000000000]}");

        return registerRepository.save(entity);
    }

}
