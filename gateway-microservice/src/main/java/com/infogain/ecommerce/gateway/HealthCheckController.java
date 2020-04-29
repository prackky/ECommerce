package com.infogain.ecommerce.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {
  
    @Autowired
    private HealthCheckService greetingService;
    
//    @Autowired
//    private IhealthCheckFeignClient feignClient;
  
    @GetMapping("/checkCartHealth")
    public String getCartHealth(Model model) {
        return greetingService.getCartHealthStatus();
    }
    
    @GetMapping("/checkProdHealth")
    public String getProdHealth(Model model) {
        return greetingService.getProdHealthStatus();
    }
    
//    @GetMapping("/checkCartHealthFeign")
//    public String getCartHealthFeign(Model model) {
//        return feignClient.getCartHealth();
//    }
//    
//    @GetMapping("/checkProdHealthFeign")
//    public String getProdHealthFeign(Model model) {
//        return feignClient.getProdHealth();
//    }
}
