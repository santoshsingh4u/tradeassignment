package com.trade.assignment.service;

import java.util.List;

import com.trade.assignment.model.Trade;

public interface TradeService {

	 	public Trade createTrade(Trade trade);
	    public Trade updateTrade(Trade trade);
	    public Trade getTrade(Long tradeId);
	    public void deleteTrade(Long tradeId);                   
	    public List<Trade> getAllTrade();
}
