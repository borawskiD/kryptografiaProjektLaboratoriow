package com.example.kryptografiazadanie6;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
}
