package com.evaExchange.evaExchange.domain.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeDto {
    private Long id;

    private Long exchangeStockId;

    private Long userId;

    private Long unitAmount;

    private double totalAmountPrice;

    private Date createDate;

    private Long createUserId;

    private Date updateDate;

    private Long updateUserId;

    private Long deleteUserId;

    private Date deleteDate;

    private Boolean isDeleted;
}
