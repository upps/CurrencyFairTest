package com.currencyfair.markettrader.repository;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.currencyfair.markettrader.model.TradeMessage;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TradeMessageRepositoryIntegTest {

	@Autowired
	private TradeMessageRepository tradeMessageRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void whenFindAll_thenReturnListOfTrades() {
		
		final TradeMessage message = new TradeMessage();
		message.setUserId("testUser");
		message.setCurrencyFrom("EUR");
		message.setCurrencyTo("USD");
		message.setAmountBuy(BigDecimal.valueOf(600.00));
		message.setAmountSell(BigDecimal.ZERO);
		message.setRate(0.96);
		message.setOriginatingCountry("FR");
		message.setTimePlaced(new Date());
		
		testEntityManager.persist(message);
		testEntityManager.flush();
	
		List<TradeMessage> allTrades = tradeMessageRepository.findAll();
		
		assertThat(allTrades.size(), is(greaterThanOrEqualTo(1)));
	}
}
