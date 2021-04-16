package com.trade.assignment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.trade.assignment.model.Trade;
import com.trade.assignment.repository.TradeRepository;
import com.trade.assignment.service.TradeServiceImpl;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TradeTests {
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");

	
	private Date parseDate(String date) {
	    try {
	        return new Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}

	@Autowired
	private TradeRepository tradesrepository;
	
//	@Autowired
//	private TradeServiceImpl tradeServiceImpl;
//	
	@Test
	@Rollback(false)
	public void testCreateTrade(){
		
			Trade trade = new Trade("T1",1,"CP-1","B1", parseDate("20/05/2020"), parseDate("20/05/2020"), "N");	
			Trade savedtrade = tradesrepository.save(trade);
			
			assertNotNull(savedtrade);
	}
	
//	@Test
//	public void testFindTradeById(){
//		
//		//String tradeid = "T1";
//		//List<Trade> trade  = tradesrepository.findByTradeId(tradeid);
//		//assertThat(trade.getTradeId.isEqualTo(tradeid));
//		
//	}
	
//	@Test
//	public void testUpdateTrade(){
//		
//	}
	
	
//	@Test
//	public void testDeleteTrade(){
//		
//	}
//	
	
}

