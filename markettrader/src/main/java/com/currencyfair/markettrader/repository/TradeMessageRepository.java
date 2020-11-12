package com.currencyfair.markettrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyfair.markettrader.model.TradeMessage;

public interface TradeMessageRepository extends JpaRepository<TradeMessage, Long>{

}
