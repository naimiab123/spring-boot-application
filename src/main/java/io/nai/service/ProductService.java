package io.nai.service;

import java.util.List;

import io.nai.entities.Product;

public interface ProductService {
	public List<Product> getProducts();
	public void addProduct(Product prod);
	public void updateProduct(Product prod);
	public void deleteProduct(Long id);
}
