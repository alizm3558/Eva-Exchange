package com.evaExchange.evaExchange.repository;

import com.evaExchange.evaExchange.domain.entity.ExchangeStockEntity;
import com.evaExchange.evaExchange.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExchangeStockServiceRepository extends JpaRepository<ExchangeStockEntity, Long> {
    
    List<ExchangeStockEntity> findAllByIsDeletedIsFalse();

    Optional<ExchangeStockEntity> findByIdAndIsDeletedIsFalse(Long id);
}
