package com.infogain.ecommerce.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HealthCheckService {
	@Value("${eureka.instance.hostname}")
	protected String instanceName;
	@Value("${server.port}")
	protected int port;

	@HystrixCommand(fallbackMethod = "defaultCartMsg")
	public String getCartHealthStatus() {
		return new RestTemplate().getForObject("http://" + instanceName + ":" + port + "/cart/health", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "defaultProdMsg")
	public String getProdHealthStatus() {
		return new RestTemplate().getForObject("http://" + instanceName + ":" + port + "/products/health", String.class);
	}

	private String defaultCartMsg() {
		return "Cart service unavailable... Default Response...";
	}
	
	private String defaultProdMsg() {
		return "Cart service unavailable... Default Response...";
	}
}
