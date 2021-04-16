package com.trade.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trade.assignment.model.Trade;
import com.trade.assignment.repository.TradeRepository;

public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	 
	@Override
	public Trade createTrade(Trade trade) {
		
		return tradeRepository.save(trade);
	}

	@Override
	public Trade updateTrade(Trade trade) {
	
		return tradeRepository.save(trade);
	}

	@Override
	public Trade getTrade(Long tradeId) {
//		Optional List<Trade> optionalTrade. =  tradeRepository.findById(tradeId);
//        if(optionalTrade.isPresent()) {
//            return optionalTrade.get();
//        }
        
		return null;
	}

	@Override
	public void deleteTrade(Long tradeId) {
		
		 tradeRepository.deleteById(tradeId);
		
	}

	@Override
	public List<Trade> getAllTrade() {
		
		//List<Trade> lst = tradeRepository.getAllTrade();
		
		return null;
	}

}
