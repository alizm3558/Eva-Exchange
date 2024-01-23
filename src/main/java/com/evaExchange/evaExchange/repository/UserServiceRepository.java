package com.evaExchange.evaExchange.repository;

import com.evaExchange.evaExchange.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserServiceRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByIsDeletedIsFalse();

    Optional<UserEntity> findByIdAndIsDeletedIsFalse(Long id);
}
