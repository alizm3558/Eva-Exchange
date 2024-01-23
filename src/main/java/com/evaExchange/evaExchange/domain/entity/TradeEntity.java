package com.evaExchange.evaExchange.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "t_trade",schema = "eva_schema")
@Data
@DynamicUpdate
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exchange_stock_id")
    private Long exchangeStockId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "unit_amount")
    private Long unitAmount;

    @Column(name = "total_amount_price")
    private double totalAmountPrice;

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
