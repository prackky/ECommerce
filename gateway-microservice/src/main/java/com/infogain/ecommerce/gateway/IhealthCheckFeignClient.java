//package com.infogain.ecommerce.gateway;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@FeignClient(name="employee-producer", url = "http://localhost:8000", fallback = IhealthCheckFeignClient.HealthClientFallback.class)
//public interface IhealthCheckFeignClient {
//	@GetMapping(value="/cart/health")
//	public String getCartHealth();
//	
//	@GetMapping(value="/product/health")
//	public String getProdHealth();
//	
//	@Component
//    public static class HealthClientFallback  {
//  
//        public String getCartHealth(){
//            return "Status from fallback method -- cart";
//        }
//        
//        public String getProdHealth(){
//            return "Status from fallback method -- product";
//        }
//    }
//
//}
