package com.currencyfair.markettrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.currencyfair.markettrader.model.TradeMessage;
import com.currencyfair.markettrader.repository.TradeMessageRepository;

@Controller
public class HomeController {

	@Autowired TradeMessageRepository tradeMessageRepository;

	@RequestMapping("/results")
	public ModelAndView home() {
		List<TradeMessage> allTrades = tradeMessageRepository.findAll();
		ModelAndView map = new ModelAndView("results");
		map.addObject("trades", allTrades);

		return map;
	}
	
}
