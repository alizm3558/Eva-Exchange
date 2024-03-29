package com.evaExchange.evaExchange.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "t_exchange_stock",schema = "eva_schema")
@Data
@DynamicUpdate
public class ExchangeStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exchange_name", nullable = false)
    private String exchangeName;

    @Column(name = "currency_type", nullable = false)
    private String currencyType;

    @Column(name = "exchange_amount")
    private Long exchangeAmount;

    @Column(name = "exchange_unit_price")
    private double exchangeUnitPrice;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false, nullable = false)
    private Date createDate;

    @Column(name = "create_user_id")
    private Long createUserId;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", insertable = false)
    private Date updateDate;

    @Column(name = "update_user_id")
    private Long updateUserId;

    @Column(name = "delete_user_id")
    private Long deleteUserId;

    @Column(name = "delete_date", insertable = false)
    private Date deleteDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
