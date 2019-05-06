package io.nai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.nai.dao.ProductRepository;
import io.nai.entities.Product;
@Service
@Primary
public class ProduitService implements ProductService{
	@Autowired
	private ProductRepository produitRepository;
	
	@Override
	public List<Product> getProducts() {
		return produitRepository.findAll();
	}

	@Override
	public void addProduct(Product prod) {
		produitRepository.save(prod);
		
	}

	@Override
	public void updateProduct(Product prod) {
		produitRepository.save(prod);
		
	}

	@Override
	public void deleteProduct(Long id) {
		Product produit = new Product();
		produit.setId(id);
		produitRepository.delete(produit);
	}

}
