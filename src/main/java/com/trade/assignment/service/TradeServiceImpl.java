package com.trade.assignment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trade.assignment.model.Trade;
import com.trade.assignment.repository.TradeRepository;


@Service
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
		Optional<Trade> optionalTrade =  tradeRepository.findById(tradeId);
        if(optionalTrade.isPresent()) {
            return optionalTrade.get();
        }
        
		return null;
	}

	@Override
	public void deleteTrade(Long tradeId) {
		
		 tradeRepository.deleteById(tradeId);
		
	}

	@Override
	public Iterable<Trade> getAllTrade() {
		
		return tradeRepository.findAll();
	}

	// Pull's all records by maturity date passed and update
	public List<Trade> findAllByMaturityDate(Date maturitydate) {
		
		//Iterable<Trade> it = tradeRepository.findAllBymaturitydate(maturitydate);
		
		for (Trade trade : tradeRepository.findAllBymaturitydate(maturitydate)) 
		{
	    	System.out.println(trade.toString());
	    
	    	if ( trade.getExpired() == "N" )
	    	{
	    			trade.setExpired("Y");
	    			tradeRepository.save(trade);
	    	}
			
	    	//log.info(trade.toString());
	    }
			
			
		return null;
	}

}
