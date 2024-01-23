package com.evaExchange.evaExchange.repository;

import com.evaExchange.evaExchange.domain.entity.TradeEntity;
import com.evaExchange.evaExchange.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeServiceRepository extends JpaRepository<TradeEntity, Long> {
    
    List<TradeEntity> findAllByIsDeletedIsFalse();

    Optional<TradeEntity> findByIdAndIsDeletedIsFalse(Long id);
}
