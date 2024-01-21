package com.evaExchange.evaExchange.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "t_exchange_stock",schema = "eva_schema")
@Data
@DynamicUpdate
public class ExchangeStockEntity {
}
