package com.infogain.ecommerce.cart;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@CrossOrigin
@RestController
//@RibbonClient(name="cart")
public class CartController extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartRepository cartRepository;

    @PostConstruct
    public void init() throws IOException {
    }

    @RequestMapping("/")
    public String index() {
        return "<h1>Welcome to Cart API!</h1>";
    }
    
    @RequestMapping("/cart/health")
    public String health() {
        return "ok";
    }

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
    public Cart cart(@PathVariable("id") String id) {
        log.debug("Received request for cart by id: {}", id);
        Cart cart = cartRepository.getCartById(id);
        log.debug("Cart: {}", cart);
        return cart;
    }

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.POST)
    public Cart cart(@PathVariable("id") String id, @RequestBody CartItem cartItem) {
        log.info("Received request to add item to cart by id: {}", id);
        Cart cart = cartRepository.addToCart(id, cartItem);
        log.debug("Cart: {}", cart);
        return cart;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public Cart cart(@RequestBody CartItem cartItem) {
        log.debug("Received request to add item to cart without id.");
        Cart cart = cartRepository.addToCart(null, cartItem);
        log.debug("Cart: {}", cart);
        return cart;
    }

    @ExceptionHandler(Exception.class)
    void handleExceptions(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error. We will be addressing this issue soon.");
    }
}