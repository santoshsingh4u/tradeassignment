package com.trade.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.trade.assignment.model.Trade;
import com.trade.assignment.repository.TradeRepository;

@SpringBootApplication
public class TradeAssignmentApplication {
	
	 private static final Logger log = LoggerFactory.getLogger(TradeAssignmentApplication.class);
	 

	public static void main(String[] args) {
		SpringApplication.run(TradeAssignmentApplication.class, args);
	}
	
	
// Utility class for date field	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");	
	private Date parseDate(String date) {
	    try {
	        return new Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	
	@Bean
	  public CommandLineRunner demo(TradeRepository repository) {
	    return (args) -> {
	      // save a few trades
	    	
	      repository.save(new Trade("T1",1,"CP-1","B1", parseDate("20/05/2020"), parseDate("20/05/2020"), "N"));
	      repository.save(new Trade("T2",2,"CP-2","B1", parseDate("20/05/2020"), parseDate("20/05/2020"), "N"));
	      repository.save(new Trade("T2",1,"CP-1","B1", parseDate("20/05/2020"), parseDate("20/05/2020"), "N"));
	      repository.save(new Trade("T3",3,"CP-3","B3", parseDate("20/05/2020"), parseDate("20/05/2020"), "Y"));
	      repository.save(new Trade("T4",4,"CP-1","B2", parseDate("20/05/2020"), parseDate("20/05/2020"), "N"));

	      // fetch all trades
	      log.info("Trades found with findAll():");
	      log.info("-------------------------------");
	      for (Trade trade : repository.findAll()) {
	    	  log.info(trade.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      Optional <Trade> trade = repository.findById(1L);
	      log.info("Trade found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(trade.toString());
	      log.info("");

	      // fetch customers by Trade
	      log.info("Trade found with findByTradeId('T1'):");
	      log.info("--------------------------------------------");
	      repository.findBytradeid("T1").forEach(t1 -> {
	        log.info(t1.toString());
	      });
	      log.info("");
	    };
	  }

}
