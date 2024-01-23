package com.evaExchange.evaExchange.domain.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeStockDto {

    private Long id;

    private String exchangeName;

    private String currencyType;

    private Long exchangeAmount;

    private double exchangeUnitPrice;

    private Date createDate;

    private Long createUserId;

    private Date updateDate;

    private Long updateUserId;

    private Long deleteUserId;

    private Date deleteDate;

    private Boolean isDeleted;
}
