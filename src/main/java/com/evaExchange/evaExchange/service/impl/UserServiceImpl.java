package com.evaExchange.evaExchange.service.impl;

import com.evaExchange.evaExchange.domain.dto.TradeDto;
import com.evaExchange.evaExchange.domain.dto.UserDto;
import com.evaExchange.evaExchange.domain.entity.UserEntity;
import com.evaExchange.evaExchange.repository.UserServiceRepository;
import com.evaExchange.evaExchange.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.modelmapper.ModelMapper;
import org.springframework.expression.ExpressionException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserServiceRepository userServiceRepository;
    @Override
    public UserDto save(UserDto userDto) {
        userDto.setIsDeleted(Boolean.FALSE);
        return this.modelMapper.map(
                this.userServiceRepository.save(
                        this.modelMapper.map(userDto, UserEntity.class)
                ), UserDto.class
        );
    }

    @Override
    public UserDto update(UserDto userDto) {
        UserDto oldDto = this.getById(userDto.getId());

        oldDto.setFirstName(userDto.getFirstName());
        oldDto.setLastName(userDto.getLastName());
        oldDto.setAmountMoney(userDto.getAmountMoney());
        oldDto.setUpdateDate(new Date());
        oldDto.setUpdateUserId(userDto.getUpdateUserId());

        return this.modelMapper.map(
                this.userServiceRepository.save(
                        this.modelMapper.map(
                                oldDto,
                                UserEntity.class
                        )
                ),
                UserDto.class
        );
    }

    @Override
    public UserDto getById(Long id) {

        return this.modelMapper.map(this.userServiceRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(()
                -> new ExpressionException("Cannot found any record with id : " + id)), UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {

        return this.userServiceRepository.findAllByIsDeletedIsFalse().stream()
                .map(userEntity -> this.modelMapper.map(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id, Long deleteUserId) {
        UserDto userDto = getById(id);
        userDto.setIsDeleted(Boolean.TRUE);
        userDto.setDeleteDate(new Date());
        userDto.setDeleteUserId(deleteUserId);
        update(userDto);
    }
}
