package com.app.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.bean.ExchangeValue;
import com.app.microservices.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repo;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from")final String from,@PathVariable("to")final String to){
		//ExchangeValue exchangeValue = new ExchangeValue(1001l, from, to, BigDecimal.valueOf(67));
		//exchangeValue.setPort(environment.getProperty("local.server.port",Integer.class));
		ExchangeValue exchangeValue = repo.findByFromAndTo(from, to).setPort(environment.getProperty("local.server.port",Integer.class));
		LOGGER.info("{}",exchangeValue);
		return exchangeValue;
	}
}
