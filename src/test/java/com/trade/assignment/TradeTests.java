package com.trade.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.trade.assignment.model.Trade;
import com.trade.assignment.repository.TradeRepository;
import com.trade.assignment.service.TradeServiceImpl;

//I commented this because this only loads JPA part and not the full spring application

//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TradeTests {
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-DD");

	
	private Date parseDate(String date) {
	    try {
	        return new Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}

	@Autowired
	private TradeRepository tradesrepository;
	
	@Autowired
	private TradeServiceImpl tradeServiceImpl;
	
	@Test
	@Rollback(false)
	public void testCreateTrade(){
		
			Trade trade = new Trade("T1",1,"CP-1","B1", parseDate("2020-05-20"), parseDate("2020-05-20"), "N");	
			Trade savedtrade = tradesrepository.save(trade);
			
			assertNotNull(savedtrade);
	}
	
//	@Test
//	public void testFindByTradeId(){
//		
//		//String tradeid = "T1";
//		//List<Trade> trade  = tradesrepository.findByTradeId(tradeid);
//		//assertThat(trade.getTradeId.isEqualTo(tradeid));
//		
//	}
	
	@Test
	@Rollback(false)
	public void testUpdateTrade(){
	
		Trade trade = new Trade("T1",1,"CP-1","B1", parseDate("2020-05-20"), parseDate("2020-05-20"), "N");	
		//trade.setDate();
		trade.setVersion(9);
		
		Trade updatedtrade = tradeServiceImpl.updateTrade(trade);
		
		assertNotNull(updatedtrade);
	}
	

	   @Test
	    public void whenFindByMaturityDate_thenCountMatch() throws ParseException {
	       
		   List<Trade> result = tradeServiceImpl.findAllByMaturityDate(
	          new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-20"));

//	        assertEquals(2, result.size());
//	        assertTrue(result.stream().map(Trade::getId)
//	          .allMatch(id -> Arrays.asList(1, 2).contains(id)));
	    }
	   
	
	@Test
	public void testDeleteTrade(){
		
	}
	
	
}

