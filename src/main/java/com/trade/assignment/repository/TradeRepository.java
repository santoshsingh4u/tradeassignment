/**
 * 
 */
package com.trade.assignment.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.trade.assignment.model.Trade;




/**
 * @author santosh
 *
 */
public interface TradeRepository extends CrudRepository<Trade,Long >
{
	// to match the field
	Iterable<Trade> findBytradeid(String string);

	public List<Trade> findAllBymaturitydate(Date maturitydate);



}
