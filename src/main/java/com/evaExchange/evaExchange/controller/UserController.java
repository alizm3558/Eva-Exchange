package com.evaExchange.evaExchange.controller;


import com.evaExchange.evaExchange.domain.dto.UserDto;
import com.evaExchange.evaExchange.repository.UserServiceRepository;
import com.evaExchange.evaExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestHeader HttpHeaders header, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@RequestHeader HttpHeaders header, @PathVariable Long id) {
        Long deleteUserId = header.get('user_id');
        this.userService.deleteById(id, deleteUserId);
        return ResponseEntity.ok("Record deleted successfully");
    }

}
