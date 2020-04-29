package com.infogain.ecommerce.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {

	@Autowired
	ProductCatalogRepository productCatalogRepository;
	
	@GetMapping("")
	public String welcome() {
		return "<h1>Welcome to product catalog</h1>";
	}

	@PostMapping("/save")
	public Product createProd(@RequestBody Product Product) {
		productCatalogRepository.save(Product);
		return Product;
	}

	@GetMapping("/getAll")
	public List<Product> listProd() {
		return productCatalogRepository.findAll();
	}
	
	@GetMapping("/get/{prodId}")
	public Product findProd(@PathVariable String prodId) {
		Optional<Product> prod = productCatalogRepository.findById(prodId);
		if(prod.isPresent()) {
			return prod.get();
		}
		return null;
	}

	@PutMapping("/update/{prodId}")
	public Product updateProd(@RequestBody Product product, @PathVariable String prodId) {
		product.set_id(prodId);
		productCatalogRepository.save(product);
		return product;
	}

	@DeleteMapping("/delete/{prodId}")
	public String deleteProd(@PathVariable String prodId) {
		productCatalogRepository.deleteById(prodId);
		return "deleted product with Id :" +prodId;
	}

}