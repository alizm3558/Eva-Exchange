package com.evaExchange.evaExchange.service;

import com.evaExchange.evaExchange.domain.dto.ExchangeStockDto;
import com.evaExchange.evaExchange.domain.dto.TradeDto;

import java.util.List;

public interface ExchangeStockService {
    ExchangeStockDto save(ExchangeStockDto exchangeStockDto);

    ExchangeStockDto update(ExchangeStockDto exchangeStockDto);

    ExchangeStockDto getById(Long id);

    List<ExchangeStockDto> getAll();

    void deleteById(Long id, Long deleteUserId);
}
