package com.app.microservices.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private Long id;
	
	private String from;
	
	private String to;
	
	private BigDecimal currencyMultiple;
	
	private BigDecimal quantity;
	
	private BigDecimal totalCalculatedAmount;
	
	private Integer port;

	public CurrencyConversionBean() {
		super();
	}

	public CurrencyConversionBean(Long id) {
		super();
		this.id = id;
	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal currencyMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, Integer port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyMultiple = currencyMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getCurrencyMultiple() {
		return currencyMultiple;
	}

	public void setCurrencyMultiple(BigDecimal currencyMultiple) {
		this.currencyMultiple = currencyMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", currencyMultiple="
				+ currencyMultiple + ", quantity=" + quantity + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", port=" + port + "]";
	}
}
