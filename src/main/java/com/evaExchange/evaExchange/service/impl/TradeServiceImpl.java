package com.evaExchange.evaExchange.service.impl;

import com.evaExchange.evaExchange.domain.dto.TradeDto;
import com.evaExchange.evaExchange.domain.dto.UserDto;
import com.evaExchange.evaExchange.domain.entity.TradeEntity;
import com.evaExchange.evaExchange.domain.entity.UserEntity;
import com.evaExchange.evaExchange.repository.TradeServiceRepository;
import com.evaExchange.evaExchange.service.TradeService;
import com.evaExchange.evaExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeServiceRepository tradeServiceRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public TradeDto save(TradeDto tradeDto) {
        tradeDto.setIsDeleted(Boolean.FALSE);
        return this.modelMapper.map(
                this.tradeServiceRepository.save(
                        this.modelMapper.map(tradeDto, TradeEntity.class)
                ), UserDto.class
        );
    }

    @Override
    public TradeDto update(TradeDto tradeDto) {
        TradeDto oldDto = this.getById(tradeDto.getId());

        oldDto.setExchangeStockId(tradeDto.getExchangeStockId());
        oldDto.setUserId(tradeDto.getUserId());
        oldDto.setUnitAmount(tradeDto.getUnitAmount());
        oldDto.setTotalAmountPrice(tradeDto.getTotalAmountPrice());
        oldDto.setUpdateDate(new Date());
        oldDto.setUpdateUserId(tradeDto.getUpdateUserId());

        return this.modelMapper.map(
                this.tradeServiceRepository.save(
                        this.modelMapper.map(
                                oldDto,
                                TradeEntity.class
                        )
                ),
                TradeDto.class
        );
    }

    @Override
    public TradeDto getById(Long id) {

        return this.modelMapper.map(this.tradeServiceRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()
                -> new ExpressionException("Cannot found any record with id : " + id)), UserDto.class);
    }

    @Override
    public List<TradeDto> getAll() {
        return this.tradeServiceRepository.findAllByIsDeletedIsFalse().stream()
                .map(tradeEntity -> this.modelMapper.map(tradeEntity, TradeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id, Long deleteUserId) {
        TradeDto tradeDto = getById(id);
        tradeDto.setIsDeleted(Boolean.TRUE);
        tradeDto.setDeleteDate(new Date());
        tradeDto.setDeleteUserId(deleteUserId);
        update(tradeDto);
    }
}
