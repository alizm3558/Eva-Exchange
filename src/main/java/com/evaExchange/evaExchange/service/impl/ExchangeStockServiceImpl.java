package com.evaExchange.evaExchange.service.impl;

import com.evaExchange.evaExchange.domain.dto.ExchangeStockDto;
import com.evaExchange.evaExchange.domain.dto.TradeDto;
import com.evaExchange.evaExchange.domain.dto.UserDto;
import com.evaExchange.evaExchange.domain.entity.ExchangeStockEntity;
import com.evaExchange.evaExchange.domain.entity.TradeEntity;
import com.evaExchange.evaExchange.repository.ExchangeStockServiceRepository;
import com.evaExchange.evaExchange.service.ExchangeStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeStockServiceImpl implements ExchangeStockService {

    @Autowired
    private ExchangeStockServiceRepository exchangeStockServiceRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ExchangeStockDto save(ExchangeStockDto exchangeStockDto) {
        exchangeStockDto.setIsDeleted(Boolean.FALSE);
        return this.modelMapper.map(
                this.exchangeStockServiceRepository.save(
                        this.modelMapper.map(exchangeStockDto, ExchangeStockEntity.class)
                ), ExchangeStockDto.class
        );
    }

    @Override
    public ExchangeStockDto update(ExchangeStockDto exchangeStockDto) {
        return null;
    }

    @Override
    public ExchangeStockDto getById(Long id) {

        return this.modelMapper.map(this.exchangeStockServiceRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()
                -> new ExpressionException("Cannot found any record with id : " + id)), ExchangeStockDto.class);
    }

    @Override
    public List<ExchangeStockDto> getAll() {
        return this.exchangeStockServiceRepository.findAllByIsDeletedIsFalse().stream()
                .map(exchangeEntity -> this.modelMapper.map(exchangeEntity, ExchangeStockDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id, Long deleteUserId) {
        ExchangeStockDto exchangeStockDto = getById(id);
        exchangeStockDto.setIsDeleted(Boolean.TRUE);
        exchangeStockDto.setDeleteDate(new Date());
        exchangeStockDto.setDeleteUserId(deleteUserId);
        update(exchangeStockDto);
    }
}
