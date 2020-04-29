package com.nikhu.ecommerce.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;



public class CartControllerTest {
	
	@InjectMocks 
	CartController cartController;

	@Mock
	CartRepository cartRepository;
	
	@Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
	
	private Cart createCart() {
		List<CartItem> cList=new ArrayList<CartItem>();
		Cart c=new Cart();
		CartItem item=createCartItem();
		cList.add(item);
		c.setCurrency("INR");
		c.setId("1");
		c.setTotal(10);
		c.setItems(cList);
		return c;
	}
	
	private CartItem createCartItem() {
		
		CartItem item=new CartItem();
		item.setCurrency("INR");
		item.setId("1");
		item.setName("test");
		item.setPrice(10);
		return item;
	}
	
	@Test
    public void testcartById() {
		Cart c=createCart();
		Mockito.when(cartRepository.getCartById(Mockito.anyString())).thenReturn(c);
		Cart cart=cartController.cart("1");
		assertEquals(cart.getItems().get(0).getCurrency(),"INR");
	}
	
	@Test
    public void testAddToCartWithId() {
		Cart c=createCart();
		CartItem item=createCartItem();
		Mockito.when(cartRepository.addToCart(Mockito.any(),Mockito.any())).thenReturn(c);
		Cart cart=cartController.cart(item);
		assertEquals(cart.getItems().get(0).getCurrency(),"INR");
	}
	
	@Test
    public void testAddToCartWithoutId() {
		Cart c=createCart();
		CartItem item=createCartItem();
		Mockito.when(cartRepository.addToCart(Mockito.any(),Mockito.any())).thenReturn(c);
		Cart cart=cartController.cart(item);
		assertEquals(cart.getCurrency(),"INR");
		
	}
	
	

}
