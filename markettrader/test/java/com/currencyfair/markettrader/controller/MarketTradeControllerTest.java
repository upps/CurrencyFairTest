package com.currencyfair.markettrader.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.currencyfair.markettrader.model.TradeMessage;
import com.currencyfair.markettrader.repository.TradeMessageRepository;

public class MarketTradeControllerTest {

	private static final String TEST_USER1 = "testUser1";
	private static final String TEST_USER2 = "testUser2";

	@InjectMocks
	MarketTradeController marketTradeController;
	
	@Mock
	TradeMessageRepository tradeMessageRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMarketTradeControllerGet() {		
		
		List<TradeMessage> mockTrades = new ArrayList<>();
		mockTrades.add(mockTradeMessage(TEST_USER1));
		mockTrades.add(mockTradeMessage(TEST_USER2));
		
		when(tradeMessageRepository.findAll()).thenReturn(mockTrades);
		
		List<TradeMessage> allTrades = marketTradeController.getTrades();
		
		verify(tradeMessageRepository).findAll();
		
		assertThat(allTrades.size(), is(equalTo(2)));
	}
	
	public TradeMessage mockTradeMessage(String userId) {
		TradeMessage message = new TradeMessage();
		message.setUserId(userId);
		
		return message;		
	}
}
