package com.app.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.microservices.bean.CurrencyConversionBean;
import com.app.microservices.feign.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from")String from,
			@PathVariable("to")String to,
			@PathVariable("quantity")BigDecimal quantity){

		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity= new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables); 
		CurrencyConversionBean conversionBean= responseEntity.getBody();		
		LOGGER.info("{}",conversionBean);
		return new  CurrencyConversionBean(conversionBean.getId(), from, to, conversionBean.getCurrencyMultiple(), quantity, quantity.multiply(conversionBean.getCurrencyMultiple()), env.getProperty("local.server.port",Integer.class));
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from")final String from,@PathVariable("to")final String to,@PathVariable("quantity")BigDecimal quantity){
		CurrencyConversionBean conversionBean = proxy.retrieveExchangeValue(from, to);
		LOGGER.info("{}",conversionBean);
		return new CurrencyConversionBean(conversionBean.getId(),from,to,conversionBean.getCurrencyMultiple(),quantity,quantity.multiply(conversionBean.getCurrencyMultiple()),conversionBean.getPort());
	}
}