package io.nai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.nai.dao.ProductRepository;
import io.nai.entities.Product;

@Service
@Primary
public class ProduitsService implements ProductService {
	@Autowired
   private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product prod) {
		productRepository.save(prod);
		
	}

	@Override
	public void updateProduct(Product prod) {
		productRepository.save(prod);
		
	}

	@Override
	public void deleteProduct(Long id) {
		Product p = new Product();
		p.setId(id);
		productRepository.delete(p);
		
	}

	
}
