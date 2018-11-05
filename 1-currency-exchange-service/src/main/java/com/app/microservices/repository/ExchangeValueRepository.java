package com.app.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.microservices.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	public ExchangeValue findByFromAndTo(String from,String to);
}
