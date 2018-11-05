package com.app.microservices.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="exchange_value")
public class ExchangeValue {
	@Id
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	@Column(name="conversion_multiple")
	private BigDecimal currencyMultiple;
	
	@Transient
	@JsonInclude
	private Integer port; 

	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id) {
		super();
		this.id = id;
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal currencyMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyMultiple = currencyMultiple;
	}

	public Long getId() {
		return id;
	}

	public ExchangeValue setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFrom() {
		return from;
	}

	public ExchangeValue setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getTo() {
		return to;
	}

	public ExchangeValue setTo(String to) {
		this.to = to;
		return this;
	}

	public BigDecimal getCurrencyMultiple() {
		return currencyMultiple;
	}

	public ExchangeValue setCurrencyMultiple(BigDecimal currencyMultiple) {
		this.currencyMultiple = currencyMultiple;
		return this;
	}

	public Integer getPort() {
		return port;
	}

	public ExchangeValue setPort(Integer port) {
		this.port = port;
		return this;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", currencyMultiple=" + currencyMultiple
				+ "]";
	}
}
