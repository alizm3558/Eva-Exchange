package com.evaExchange.evaExchange.service;

import com.evaExchange.evaExchange.domain.dto.TradeDto;
import com.evaExchange.evaExchange.domain.dto.UserDto;

import java.util.List;

public interface TradeService {
    TradeDto save(TradeDto tradeDto);

    TradeDto update(TradeDto tradeDto);

    TradeDto getById(Long id);

    List<TradeDto> getAll();

    void deleteById(Long id, Long deleteUserId);
}
