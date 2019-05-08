package io.nai.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nai.entities.Product;
import io.nai.service.ProductService;
import io.nai.service.ProduitsService;

@RestController
@RequestMapping("api/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProduitsService productService;
	@GetMapping
     public List<Product> getProduct(){
	    return productService.getProducts();
  }
	@PostMapping
	public void addToListProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	@PutMapping
	public void updateTheProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
