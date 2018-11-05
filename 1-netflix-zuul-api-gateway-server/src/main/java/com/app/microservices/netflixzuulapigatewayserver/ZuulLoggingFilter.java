package com.app.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	//Zuul FilterImplementation
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
	
	public boolean shouldFilter() {
		return true;	//Whether we want to execute Filter or Not   
	}
	
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("Request -> {} Request Uri -> {}",request,request.getRequestURI());
		return LOGGER;
	}
	
	public String filterType() {
		return "pre";	//Execute ZuulLoggingFilter before Request 
	}
	
	public int filterOrder() {	//To Set Priority for this particular LoggingFilter
		return 1;
	}
	
}
