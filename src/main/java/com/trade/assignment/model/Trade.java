package com.trade.assignment.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="Trades")
public class Trade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="Id")
	private Long Id;
	
	//@Column(name="tradeid")
	private String tradeid;
	
	//@Column(name="version")
	private int version;
	
	//@Column(name="counterpartyid")
	private String counterpartyid;	
	
	//@Column(name="counterpartyid")
	private String bookid;
	
	@Type(type = "date")
	//@Column(name="maturitydate")
	private Date maturitydate;
	
	@Type(type = "date")
	@Column(name="createddate")
	private Date createddate;	
	
	//@Column(name="expired")
	private String expired;
	
	public Trade(){};
	
	public Trade(String tradeid, int version, String counterpartyid, 
			String bookid, Date maturitydate,Date createddate, String expired) 
	{
	
		this.tradeid = tradeid;
		this.version = version;
		this.counterpartyid = counterpartyid;
		this.bookid = bookid;
		this.maturitydate = maturitydate;
		this.createddate = createddate;
		this.expired = expired;
	}
//
//	/**
//	 * @return the tradeid
//	 */
//	public String getTradeid() {
//		return tradeid;
//	}
//
//	/**
//	 * @param tradeid the tradeid to set
//	 */
//	public void setTradeid(String tradeid) {
//		this.tradeid = tradeid;
//	}
//
//	/**
//	 * @return the version
//	 */
//	public Integer getVersion() {
//		return version;
//	}
//
//	/**
//	 * @param version the version to set
//	 */
//	public void setVersion(Integer version) {
//		this.version = version;
//	}
//
//	/**
//	 * @return the counterpartyid
//	 */
//	public String getCounterpartyid() {
//		return counterpartyid;
//	}
//
//	/**
//	 * @param counterpartyid the counterpartyid to set
//	 */
//	public void setCounterpartyid(String counterpartyid) {
//		this.counterpartyid = counterpartyid;
//	}
//
//	/**
//	 * @return the bookid
//	 */
//	public String getBookid() {
//		return bookid;
//	}
//
//	/**
//	 * @param bookid the bookid to set
//	 */
//	public void setBookid(String bookid) {
//		this.bookid = bookid;
//	}
//
//	/**
//	 * @return the maturitydate
//	 */
//	public Date getMaturitydate() {
//		return maturitydate;
//	}
//
//	/**
//	 * @param maturitydate the maturitydate to set
//	 */
//	public void setMaturitydate(Date maturitydate) {
//		this.maturitydate = maturitydate;
//	}
//
//	/**
//	 * @return the createddate
//	 */
//	public Date getCreateddate() {
//		return createddate;
//	}
//
//	/**
//	 * @param createddate the createddate to set
//	 */
//	public void setCreateddate(Date createddate) {
//		this.createddate = createddate;
//	}
//
//	/**
//	 * @return the expired
//	 */
//	public String getExpired() {
//		return expired;
//	}
//
//	/**
//	 * @param expired the expired to set
//	 */
//	public void setExpired(String expired) {
//		this.expired = expired;
//	}

	@Override
	public String toString() {
		return "Trade [tradeid=" + tradeid + ", version=" + version + ", counterpartyid=" + counterpartyid + ", bookid="
				+ bookid + ", maturitydate=" + maturitydate + ", createddate=" + createddate + ", expired=" + expired
				+ "]";
	}
	
	
	

}
