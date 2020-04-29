package com.nikhu.ecommerce.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductCatalogControllerTest {

	@InjectMocks 
	ProductCatalogController productController;
	
	@Mock
	ProductCatalogRepository productCatalogRepository; 
	
	 @Before
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }
	
	@SuppressWarnings("unchecked")
	@Test
    public void testcreateProd() {
		Product p=new Product();
		p.set_id("1");
		p.setCurrency("INR");
		p.setImage("xyx");
		Mockito.when(productCatalogRepository.save(p)).thenReturn(p);
		Product p1=productController.createProd(p);
		assertEquals(p1.getCurrency(),"INR");
		System.out.println();
	}
	@Test
    public void testListProd() {
		List<Product> productList=new ArrayList<Product>();
		Product p=new Product();
		p.set_id("1");
		p.setCurrency("INR");
		p.setImage("xyx");
		productList.add(p);
		Mockito.when(productCatalogRepository.findAll()).thenReturn(productList);
		List<Product> productList1=productController.listProd();
		assertEquals(productList1.get(0).getCurrency(),"INR");
	}
	
	@Test
    public void testfindProd() {
		Product p=new Product();;
		p.set_id("1");
		p.setCurrency("INR");
		p.setImage("xyx");
		Mockito.when(productCatalogRepository.findById(Mockito.anyString())).thenReturn(Optional.of(p));
		Product product=productController.findProd("1");
		assertEquals(product.getCurrency(),"INR");
	}
	
	@Test
    public void testupdateProd() {
		Product p=new Product();;
		p.set_id("1");
		p.setCurrency("INR");
		p.setImage("xyx");
		Mockito.when(productCatalogRepository.save(p)).thenReturn(p);
		Product product=productController.updateProd(p, "1");
		assertEquals(product.getCurrency(),"INR");
		
	}
	

	@Test
    public void testdeleteProd() {
		Product p=new Product();;
		p.set_id("1");
		p.setCurrency("INR");
		p.setImage("xyx");
		String id=productController.deleteProd("1");
		assertEquals(id,"deleted product with Id :1");
		
	}



}
