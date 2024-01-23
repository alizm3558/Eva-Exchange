package com.evaExchange.evaExchange.controller;

import com.evaExchange.evaExchange.domain.dto.ExchangeStockDto;
import com.evaExchange.evaExchange.domain.dto.ExchangeTradeDto;
import com.evaExchange.evaExchange.domain.dto.TradeDto;
import com.evaExchange.evaExchange.service.ExchangeStockService;
import com.evaExchange.evaExchange.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/exchange")
@RestController
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @Autowired
    private ExchangeStockService exchangeStockService;

    @GetMapping("/{id}")
    public ResponseEntity<TradeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.tradeService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<TradeDto>> getAll() {
        return ResponseEntity.ok(tradeService.getAll());
    }

    @PutMapping
    public ResponseEntity<TradeDto> update(@RequestHeader HttpHeaders header, @RequestBody TradeDto tradeDto) {
        return ResponseEntity.ok(tradeService.update(tradeDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@RequestHeader HttpHeaders header, @PathVariable Long id) {
        Long deleteUserId = header.get('user_id');
        this.tradeService.deleteById(id, deleteUserId);
        return ResponseEntity.ok("Record deleted successfully");
    }

    @PostMapping("trading/{id}")
    public ResponseEntity<TradeDto> update(@RequestHeader HttpHeaders header,@PathVariable Long id, @RequestBody ExchangeTradeDto exchangeTradeDto) {

        TradeDto oldtDto=tradeService.getById(id);
        oldtDto.setUnitAmount(oldtDto.getUnitAmount()-exchangeTradeDto.getAmount());
        oldtDto.setTotalAmountPrice(oldtDto.getUnitAmount()*(oldtDto.getTotalAmountPrice()/oldtDto.getUnitAmount()));
        oldtDto.setUserId(header.get('user_id'));
        return ResponseEntity.ok(tradeService.update(oldtDto));
    }

}
