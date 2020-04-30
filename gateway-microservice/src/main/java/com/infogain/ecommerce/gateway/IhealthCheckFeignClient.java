package com.infogain.ecommerce.gateway;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="cart-microservice", fallback = IhealthCheckFeignClient.HealthClientFallback.class)
public interface IhealthCheckFeignClient {
	@RequestMapping(value="/cart/health", method = RequestMethod.GET)
	public String getCartHealth();
	
	@RequestMapping(value="/products/health", method = RequestMethod.GET)
	public String getProdHealth();
	
	@Component
    public static class HealthClientFallback  implements IhealthCheckFeignClient{

		@Override
		public String getCartHealth(){
            return "Status from fallback method -- cart";
        }
		@Override
        public String getProdHealth(){
            return "Status from fallback method -- product";
        }
  
        
    }

}
