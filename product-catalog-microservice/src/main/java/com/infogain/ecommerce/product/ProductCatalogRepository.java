package com.infogain.ecommerce.product;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCatalogRepository extends MongoRepository<Product, Long> {

	void deleteById(String prodId);

	Optional<Product> findById(String prodId);

}
