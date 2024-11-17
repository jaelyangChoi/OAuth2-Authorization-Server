package org.example.oauth2authorizationserver.repository;

import org.example.oauth2authorizationserver.entity.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, String> {

    Optional<AuthorizationEntity> findByState(String state);
    Optional<AuthorizationEntity> findByAuthorizationCodeValue(String authorizationCode);
    Optional<AuthorizationEntity> findByAccessTokenValue(String accessToken);
    Optional<AuthorizationEntity> findByRefreshTokenValue(String refreshToken);
    Optional<AuthorizationEntity> findByOidcIdTokenValue(String idToken);
    Optional<AuthorizationEntity> findByUserCodeValue(String userCode);
    Optional<AuthorizationEntity> findByDeviceCodeValue(String deviceCode);
    @Query("select a from AuthorizationEntity a where a.state = :token" +
            " or a.authorizationCodeValue = :token" +
            " or a.accessTokenValue = :token" +
            " or a.refreshTokenValue = :token" +
            " or a.oidcIdTokenValue = :token" +
            " or a.userCodeValue = :token" +
            " or a.deviceCodeValue = :token"
    )
    Optional<AuthorizationEntity> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValueOrOidcIdTokenValueOrUserCodeValueOrDeviceCodeValue(@Param("token") String token);
}
