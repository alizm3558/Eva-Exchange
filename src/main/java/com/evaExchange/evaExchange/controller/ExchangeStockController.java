package com.evaExchange.evaExchange.controller;

import com.evaExchange.evaExchange.domain.dto.ExchangeStockDto;
import com.evaExchange.evaExchange.domain.dto.UserDto;
import com.evaExchange.evaExchange.service.ExchangeStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/stock")
@RestController
public class ExchangeStockController {

    @Autowired
    private ExchangeStockService exchangeStockService;

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeStockDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.exchangeStockService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ExchangeStockDto>> getAll() {
        return ResponseEntity.ok(exchangeStockService.getAll());
    }

    @PutMapping
    public ResponseEntity<ExchangeStockDto> update(@RequestHeader HttpHeaders header, @RequestBody ExchangeStockDto userDto) {
        return ResponseEntity.ok(exchangeStockService.update(userDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@RequestHeader HttpHeaders header, @PathVariable Long id) {
        Long deleteUserId = header.get('user_id');
        this.exchangeStockService.deleteById(id, deleteUserId);
        return ResponseEntity.ok("Record deleted successfully");
    }
}
