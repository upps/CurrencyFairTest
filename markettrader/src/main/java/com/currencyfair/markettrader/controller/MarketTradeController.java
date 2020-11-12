package com.currencyfair.markettrader.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currencyfair.markettrader.model.TradeMessage;
import com.currencyfair.markettrader.repository.TradeMessageRepository;


@RestController
@RequestMapping("api/cf/")
public class MarketTradeController {

	private static final Logger logger = LoggerFactory.getLogger(MarketTradeController.class);

	@Autowired 
	private TradeMessageRepository tradeMessageRepository;

	@GetMapping("/trade")
	public List<TradeMessage> getTrades(){
		logger.debug("Getting all trades");
		return tradeMessageRepository.findAll();
	}

	@PostMapping("/tradeMessage")
	public ResponseEntity<TradeMessage> createTrade(@Valid @RequestBody TradeMessage tradeMessage) {
		tradeMessageRepository.save(tradeMessage);
		return new ResponseEntity<TradeMessage>(tradeMessage, HttpStatus.OK);
	}

}
