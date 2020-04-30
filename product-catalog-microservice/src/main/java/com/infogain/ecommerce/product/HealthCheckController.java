package com.infogain.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
  
    @Autowired
    private IhealthCheckFeignClient feignClient;
  
    
    @GetMapping("/products/checkCartHealthFeign")
    public String getCartHealthFeign(Model model) {
        return feignClient.getCartHealth();
    }
    
}
