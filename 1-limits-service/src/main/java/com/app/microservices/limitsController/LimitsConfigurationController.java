package com.app.microservices.limitsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.bean.LimitsConfiguration;
import com.app.microservices.configuration.LimitConfig;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private LimitConfig config;
	
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration(){
		return new LimitsConfiguration(config.getMaximum(),config.getMinimum());
	}
}
