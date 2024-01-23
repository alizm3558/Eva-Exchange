package com.evaExchange.evaExchange.service;

import com.evaExchange.evaExchange.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    UserDto getById(Long id);

    List<UserDto> getAll();

    void deleteById(Long id, Long deleteUserId);
}
