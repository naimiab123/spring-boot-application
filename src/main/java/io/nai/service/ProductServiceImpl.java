package io.nai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.nai.entities.Product;
@Service
public class ProductServiceImpl implements ProductService {
 private List<Product> products;
  public ProductServiceImpl() {
	  products = new ArrayList<Product>();
	  products.add(new Product("TV AS1", 2, 1045.99));
	  products.add(new Product("SMART-PHONE", 15, 2035.99));
	  products.add(new Product("MONITOR-SAMSUNG", 45, 1085.99));
	  products.add(new Product("MONITOR-NOKIA", 11, 7085.99));
  }
	@Override
	public List<Product> getProducts() {
		
		return products;
	}

	@Override
	public void addProduct(Product prod) {
		products.add(prod);

	}

	@Override
	public void updateProduct(Product prod) {
		products.remove(prod);
		products.add(prod);

	}

	@Override
	public void deleteProduct(String ref) {
		Product prd =new Product();
		prd.setRef(ref);
		products.remove(prd);
	}

}
