package org.example.oauth2authorizationserver.repository;

import org.example.oauth2authorizationserver.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegisterRepository extends CrudRepository<RegisterEntity, String> {
    Optional<RegisterEntity> findByClientId(String clientId);
}
